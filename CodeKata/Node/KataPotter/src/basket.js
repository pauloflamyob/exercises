import Big from 'big.js';
import bookGrouping from './bookGrouping';

const PRICE_OF_BOOK = 8;
const discountRates = {
  1: 1,
  2: 0.95,
  3: 0.9,
  4: 0.8,
  5: 0.75
};

const getPriceOfGroup = books =>
  Number(new Big(books.length).times(PRICE_OF_BOOK).times(discountRates[books.length]).toFixed(2));

const getPrice = books => {
  const booksInGroups = bookGrouping.create(books);
  return booksInGroups.reduce((price, books) => Number(new Big(getPriceOfGroup(books)).plus(price).toFixed(2)), 0);
};

export default {
  getPrice,
};