const repeatI = count => {
    return Array(count).fill('I').join("")
};

const generateRomanNumerals = decimalNumber => {
    if (decimalNumber === 0) {
        return "";
    } else if (decimalNumber <= 3) {
        return repeatI(decimalNumber);
    } else if (decimalNumber === 4) {
        return 'IV';
    } else if (decimalNumber >= 5 && decimalNumber < 9) {
        return "V" + generateRomanNumerals(decimalNumber - 5);
    } else {
        return  generateRomanNumerals(10 - decimalNumber) + 'X';
    }
}

module.exports = {
    generateRomanNumerals
}