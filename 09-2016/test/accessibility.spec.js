var a11y = require('a11y');
var assert = require('chai').assert;

let urls = ['https://www.google.com'];

accessibility(urls);

function accessibility(urls) {
    var failures = [];

    for (let url of urls) {
        a11y(url, function (err, reports) {
            try {
                reports.audit.forEach(function (failure) {
                    if (failure.result === 'FAIL' && failure.severity === 'Severe') {
                        console.log(`\n${url}: ${failure.heading} \n ${failure.elements}`);
                        failures.push(`${url}: ${failure.heading}`);
                    }
                });
            } catch (TypeError) {
                throw err;
            }
            assert.lengthOf(failures, 0, 'Found Failures (check logs)');
        });
    }

    return failures.length;
}