const getBookAppearances = books => books.reduce((bookAppearances, book) => {
  bookAppearances[book] = ((bookAppearances[book] | 0) + 1);
  return bookAppearances;
}, {});

const getAmountOfBookGroupsToCreate = bookAppearances => Object.keys(bookAppearances).reduce(
  (amountOfBookGroups, book) => amountOfBookGroups > bookAppearances[book] ? amountOfBookGroups : bookAppearances[book]
, 0);

const create = books => {
  const bookAppearances = getBookAppearances(books);
  const amountOfBookGroups = getAmountOfBookGroupsToCreate(bookAppearances);

  let index = 0;
  return Object.keys(bookAppearances).reduce((bookGroups, book) => {
    for (let numOfBookAppearances = bookAppearances[book]; numOfBookAppearances > 0; numOfBookAppearances--) {
      if (index >= amountOfBookGroups) {
        index = 0;
      }
      bookGroups[index] = bookGroups[index].concat([Number(book)]);
      index++;
    }
    return bookGroups;
  }, Array(amountOfBookGroups).fill([]));
};

export default {
  create,
}