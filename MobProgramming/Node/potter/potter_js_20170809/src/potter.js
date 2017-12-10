const calculateDiscount = (books) =
>
{
    let discount = 1;

    if (books.length === 1) {
        discount = 0;
    } else if (books.length === 2) {
        discount = books[0] !== books[1] ? 5 : 0;
    } else if (books.length === 3) {
        discount = 10;
    }
    else if (books.length === 4) {
        discount = 20;
    }
    else if (books.length === 5) {
        discount = 25;
    }

    return discount;
}


var price_items = function (books) {
    const discount = calculateDiscount(books);
    return (books.length * 8) - (books.length * (discount / 100) * 8);

}

module.exports = {
    price_items
}
