import http from 'k6/http';
import { check, sleep, group } from 'k6';

const BASE_URL = 'https://tbcbank.ge';

export const options = {
  vus: 20,
  duration: '60s',

  thresholds: {
    http_req_duration: ['p(95)<900', 'p(99)<1800'],
    http_req_failed: ['rate<0.01'],
    checks: ['rate>0.99'],
  },
};

export default function () {

  group('Cards Page Load Test (20 VUs)', function () {

    const responses = http.batch([
      ['GET', `${BASE_URL}/ka/cards`],
      ['GET', `${BASE_URL}/`],
    ]);

    responses.forEach((res) => {
      console.log(`URL: ${res.url}`);
      console.log(`Status: ${res.status}`);
      console.log(`Response time: ${res.timings.duration} ms`);

      check(res, {
        'status is 200': (r) => r.status === 200,
        'response < 2s': (r) => r.timings.duration < 2000,
      });
    });
  });

  sleep(Math.random() * 3 + 1);
}