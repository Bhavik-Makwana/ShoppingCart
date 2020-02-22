# Notes

## Assumptions made
- VAT is already included in the price as this is not mentioned anywhere and is normally included in European countries
- All customers in a branch either want the price first or after as it doesn't say some customers in some branches want price first just some branches do
- Price position on the receipt is set on a store by store basis
- Ordering of receipt items more important than performance of solution (TreeMap -> HashMap) as this is one of the listed requirements
- 'Patches' is assumed to be a modified version of the code base on a separate development branch to be merged to prod after all test cases pass as I am unsure how else you would patch production code
- Ideally would be set up with a CI pipeline


## Patch process
- Demonstration purposes, merge dev branch to master after all tests pass
![Patch screenshot](https://github.com/Bhavik-Makwana/ShoppingCart/edit/master/images/merge.png "Patch Example")

