var assert = require('assert');
var potter = require('../src/potter');
describe('Price Books', function () {
    it('first book only', function () {
        assert.equal(potter.price_items([1]), 8);
    });

     it('two same books', function() {
      assert.equal(potter.price_items([1, 1]), 16);
    });

    it('Two different books', function () {
        assert.equal(potter.price_items([1, 2]), 15.2);
    });

    it('Three different books', function () {
        assert.equal(potter.price_items([1, 2, 3]), 21.6);
    });

    it('three mixed books, 2 the same and 1 different', function() {
        assert.equal(potter.price_items([1, 2, 1]), 23.2);
    });

    it('Four different books', function () {
        assert.equal(potter.price_items([1, 2, 3, 4]), 25.6);
    });

    it('Five different books', function () {
        assert.equal(potter.price_items([1, 2, 3, 4, 5]), 30);
    });

});
