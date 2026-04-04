import http from 'k6/http';
import { check, sleep, group } from 'k6';
import { textSummary } from 'https://jslib.k6.io/k6-summary/0.0.1/index.js';

const BASE_URL = 'https://tbcbank.ge';

const params = {
  headers: {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7)',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9',
    'Accept-Language': 'en-US,en;q=0.9',
    'Connection': 'keep-alive',
  },
};

export const options = {
  vus: 100,
  duration: '60s',

  thresholds: {
    http_req_duration: ['p(95)<1200', 'p(99)<2500'],
    http_req_failed: ['rate<0.02'],
    checks: ['rate>0.98'],
  },
};

export default function () {

  group('Cards Page Stress Test (100 VUs)', function () {

    const responses = http.batch([
      ['GET', `${BASE_URL}/ka/cards`, null, params],
      ['GET', `${BASE_URL}/`, null, params],
    ]);

    responses.forEach((res) => {
      console.log(`URL: ${res.url}`);
      console.log(`Status: ${res.status}`);
      console.log(`Response time: ${res.timings.duration} ms`);

      check(res, {
        'status is 200': (r) => r.status === 200,
        'response < 3s': (r) => r.timings.duration < 3000,
      });
    });
  });

  sleep(Math.random() * 3 + 1);
}


// for report json using command :
// k6 run stress.js --summary-export=summary.json