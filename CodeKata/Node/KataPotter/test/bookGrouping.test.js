import { expect } from 'chai';
import bookGrouping from '../src/bookGrouping';

describe('books groupings should', () => {
  it('create 2 groupings of 4', () => {
    const books = [1, 1, 2, 2, 3, 3, 4, 5];
    const result = bookGrouping.create(books);
    expect(result.length).to.equal(2);
    expect(result).to.deep.equal([[1, 2, 3, 4], [1, 2, 3, 5]]);
  });
  it('create 5 groupings, 2 of five and 3 of four', () => {
    const books = [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5];
    const result = bookGrouping.create(books);
    expect(result.length).to.equal(5);
    expect(result).to.deep.equal([
      [1, 2, 3, 4, 5],
      [1, 2, 3, 4, 5],
      [1, 2, 3, 4],
      [1, 2, 3, 5],
      [1, 2, 4, 5],
    ]);
  });
});