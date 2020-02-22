# ShoppingCart

This is a partial implementation of the software behind a supermarket till system. It is intended for use as a take-home project by candidates. The existing implementation is not intended to be high-quality code.

The goal of the software is to record items as they're swiped through a supermarket till, and then to print a receipt for the supermarket customer (multiple ShoppingCart.addItem calls, then a call to ShoppingCart.printReceipt). Candidates should reimplement ShoppingCart, but must adhere to the existing interface, IShoppingCart. Please make any decisions you feel appropriate in the absence of sufficient information.

Please note; there are no intentional tricks/traps in this project. Please work-around any bugs you discover & note them for the discussion during the onsite.

- This project was ran and tested on intellij

## Dependencies
  gradle (https://gradle.org/install)
  - The dependencies have not changed from the initial code

## Build
  gradle build

## Test
  gradle test

## Patch Notes
- Added a Receipt Object
- Added a ReceiptItem Object to easily add/remove attributes associated with items in a receipt
- Tests made more flexible, reducing the amount of redundant code so less changes have to be made to the tests on a change to the codebase
- Test coverage is now 100% methods and 100% LoC
- Boolean parameter added to ShoppingCart constructor to set whether receipt should display price or not
- IShoppingCart left untouched
- Total line displays at bottom of receipt
- Updated receipt layout
- Receipt layout more flexible with ability to change column withds on change of columnWidth attribute in RecieptObject
- Added JavaDocs to each non getter/setter method
- Added helper methods to ShoppingCart to make more rounded and usable