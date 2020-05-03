# u7020050

Great work on the GUI for the assignment! In particular good use of program constants for easily modifiable code.
In lines 29-63 I see that most of the lines in the bodies of the for loops are common between the loops. It is good
to factor out common code from structures wherever possible. Lines 112-136 could be replaced with a loop to generate
the ImageViewers for each player - that way the number of players more easily configurable (you could modify the code
easily to work with even more players than the Metro game supports with relative ease).

# Feedback for all members

D2G will have an expectation that groups adopt good use of OOP in their code. As such I recommend intentionally using
custom objects to replace strings in the way that the game board is represented.