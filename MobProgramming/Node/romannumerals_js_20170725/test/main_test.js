var assert = require('assert');
var roman = require('../src/main');

const createTestResult = (decimal, romanNumeral) => ({decimal, romanNumeral})

describe('Array', function () {
    describe('roman numerals', function () {

        const TEST_DATA = [
            createTestResult(1, "I"),
            createTestResult(2, "II"),
            createTestResult(3, "III"),
            createTestResult(4, "IV"),
            createTestResult(5, "V"),
            createTestResult(6, "VI"),
            createTestResult(7, "VII"),
            createTestResult(8, "VIII"),
            createTestResult(9, "IX"),
            createTestResult(10, "X"),
        ]
        
        TEST_DATA.forEach(({decimal, romanNumeral}) => {
            it(`should return ${romanNumeral} when ${decimal}`, () => {
                assert.equal(roman.generateRomanNumerals(decimal), romanNumeral)
            })
        })
    });
});