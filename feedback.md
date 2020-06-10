# Assignment Two Feedback

WARNING: REPO IS NOT UP TO DATE.
WARNING: TESTS HAVE BEEN CHANGED BY GROUP.  Please check changes.

## Group  wed12a
u7020050 Yiwei Wu
u6648214 Runa Ebihara
u6864755 Shenwanyue Shang

## Tutor Comment

Great use of Object Orientation, particularly in the JavaFX code (specialising exisitng JavaFX objects), as well as in
the solver. `getEnd` on line Score.java:152 appears to be essentially a static method, and so should be given the
`static` annotation. The best example of OOP is `RoadMap` in Score.java. Remember to equip all custom classes (other
than those used for trivial purposes such as tuples etc) with instance methods, and document how the public-facing
methods may be used with Java Docstrings.

On the topic of code quality, it is great to see such a consistent style throughout your entire project. Some minor
points:

 - Collection types used as parameters should have their exact (implementation) type unspecified
 - Make sure to remove all program constants from your code and instead reference them as constants by name - declaring
them at the top of your file

I appreciate your implementation of hands with multiple pieces, as well as your static evaluation heuristic in your advanced AI.
Would be good however to see improvements to your UI in its ability to teach new users how to play your game. Sometimes,
design choices such as concise use of text or groupings of visual items accomplish this, but I feel the biggest improvement
applies to the menu screen, the tile selection screen and the placement screen, which is to prohibit players from making
illegal moves.

Some additional bug fixing and better teaching for unnacustomed players would award higher marks for 'Works well and easy to run'.

'Exceptional' marks awarded for novel AI heuristic. Improvements to the sophistication of your AI would award higher marks
in this area, and fixing the bug with AI halting from playing would award remainder of marks for basic AI.

## Mark

**  /13.0**

## Miscellaneous marks

| Level | Requirement | Result |
|:-:|---|:-:|
||All files correct                     | 0.5/.5  |
||Authorship clear for all classes      | 0.25/.25 |
||Program runs from JAR                 | 0.5/.5  |
||Appropriate use of Git                | 0.5/.5  |
|P|Appropriate use of OO features       | 0.65/.75 |
|P|Presentation PDF complete            | 0.5/.5  |
|CR|Program well designed               | 0.5/.5  |
|CR|Comments clear and sufficient       | 0.2/.25 |
|CR|Coding style good                   | 0.25/.25 |
|CR|Appropriate use of JUnit tests      | 0.25/.25 |
|D|Design and code of very high quality | 0.4/.5  |
|D|Demonstrates interesting extensions  | 0.5/.75 |
|D|Works well and easy to run           | 0.1/.25 |
|HD|Game is exceptional                 | 0.2/1.0 |

**Total for miscellaneous marks:**  /6.75

## Game marks (manual)

| Level | Requirement | Result |
|:-:|---|:-:|
|CR|Tiles snap into place (8)        | .25/.25 |
|CR|Only valid placements allowed (8)| 0/.25 |
|CR|Score updated after placement (8)| .5/.5  |
|D |Basic computer opponent (10)     | .4/.5  |
|HD|Advanced computer opponent (11)  | .3/.5  |
|HD|Variants (12)                    | .25/.25 |

**Total for manual marks:** /2.25

## Test results

```
Test Name   Tests Passed  Weighting    Score
-----              -----      -----    -----
task2                4/4        0.5      0.5
task3                3/3        0.5      0.5
task5                4/4        0.5      0.5
task6                4/4        1.0      1.0
task7                3/3       0.75     0.75
task9                3/3       0.75     0.75
-----              -----     Total:  4.0/4.0
```
## Originality statements

#### Originality statement G
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  Stage G represents the culmunation of the entire assignment.  We declare that
  everything we have submitted for for all stages of this assignment was
  entirely our own work, with the following exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
  - name:
    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
code:
  - comment:
    url:
    licence:

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment:
    url:
    licence:


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name:
    uid:
  - name:
    uid:
  - name:
    uid:

#### Originality statement F
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage F of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: Images for players
    url: https://www.pinterest.com.au/cheryldctn/impressionist-portrait/
    licence: Photo

  - comment: Enum type
    url: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    licence: https://www.oracle.com/legal/terms.html

  - comment: Substring
    url: https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
    licence: https://www.oracle.com/legal/terms.html

# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yiwei Wu
    uid: u7020050
  - name: Birdy Shang
    uid: u6864755
  - name: Runa Ebihara
    uid: u6648214

#### Originality statements E
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:

name: Runa Ebihara
uid: u6648214
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
#
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)


# sign *your* name and uid here
name: Birdy Shang
uid: u6864755
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)


# sign *your* name and uid here
name: Yiwei Wu
uid: u7020050

#### Originality statements D
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work

# sign *your* name and uid here
name: Runa Ebihara
uid: u6648214
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:


# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
  - name: None
    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
code:
  - comment: None
    url: None
    licence: None

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: None
    url: None
    licence: None


# sign *your* name and uid here
name: Birdy Shang
uid: u6864755
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  I declare that everything I have submitted for stage D of this assignment
  and all stages before it is entirely my own work, with the following
  exceptions:


# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
  - name: None
    comment: >-

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)
code:
  - comment: None
    url: None
    licence: None

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: None
    url: None
    licence: None


# sign *your* name and uid here
name: Yiwei Wu
uid: u7020050

#### Originality statement C
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage C of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)

# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yiwei Wu
    uid: u7020050
  - name: Birdy Shang
    uid: u6864755
  - name: Runa Ebihara
    uid: u6648214

#### Originality statement B
# IMPORTANT: It is very important that you correctly complete this originality
# statement.
#
# This is your statement of your submitted work being your own.
# Incorrectly filling out this statement could lead to charges
# of academic misconduct.
# 
# For information on how to fill this out correctly, see
# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
#

declaration: >-
  We declare that everything we have submitted for Stage B of this assignment
  and all stages before it is entirely our own work, with the following
  exceptions:

# Use this to list names of people who you collaborated with, and a
# comment about what you collaborated on.
#
# Add as many "name+comment" entries as necessary
# (or remove it altogether if you haven't collaborated with anyone)
collaboration:
  - name: TIAN WU
    comment: He shared a metro card set so we can print out.

# Use this to list any code that you used that you did not write,
# aside from code provided by the lecturer.  Provide a comment
# explaining your use and the URL to that code and the licence for
# that code
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external code)


# Use this to list any assets (artwork, sound, etc) that you used.
# Provide a comment explaining your use of that asset and the URL
# and license for the asset
#
# Add as many "url+licence+comment" entries as necessary
# (or remove it altogether if you haven't used any external assets)
assets:
  - comment: Metro Game IOS Version
    url: None
    licence: NA


# Sign *your* name and uids here. (Remove entries if you have fewer
# than three members.)
signatures:
  - name: Yiwei Wu
    uid: u7020050
  - name: Runa Ebihara
    uid: u6648214
  - name: Birdy Shang
    uid: u6864755

## Git Contributions
#### Commit count via git log
```
     21 birdy <u6864755@anu.edu.au>
      2 Bob <u6648214@anu.edu.au>
      1 Cindy <u6864755@anu.edu.au>
      6 Josh Milthorpe <josh.milthorpe@anu.edu.au>
     19 Luna <u6648214@anu.edu.au>
      7 Rohan McLure <rohanmclure@gmail.com>
      2 Runa Ebihara <u6648214@anu.edu.au>
      3 Shenwanyue Shang <u6864755@anu.edu.au>
     23 u7020050 <u7020050@anu.edu.au>
     73 Yiwei Wu <yiwei.wu@anu.edu.au>

```
#### Line count via git blame
```
    284 birdy
    624 Josh
    393 Luna
      6 Not
    134 u7020050
    751 Yiwei
```
## Git Log
```
commit f61a77a4f4753c4377016ff375453df346ff7f5e
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Mon May 11 22:27:05 2020 +1000

    Deliverable D2F Feedback

commit 8e6f5093ea15cb78fc0a49aa82dbcba987b6c5c7
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 11 01:04:37 2020 +1000

    Update Jar
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 3ffd51188916044353377d1f977d7e3818bb8224
Merge: 2183b9a 3eddf6e
Author: u7020050 <u7020050@anu.edu.au>
Date:   Mon May 11 00:54:59 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 3eddf6ea78f440d2659860550893c9930af576e1
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 11 00:54:12 2020 +1000

    Delete MANIFEST.MF

commit 2183b9af15588bc5b43dba1f174c954c5109f8ca
Merge: 57b368a 36943f9
Author: u7020050 <u7020050@anu.edu.au>
Date:   Mon May 11 00:52:33 2020 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit 57b368a0efc5c0d5a0f037926b03452860393805
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 11 00:52:15 2020 +1000

    Update so that players' images can adjust sizes according to number of players
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 36943f907d2276ecbbbcba83e5ac594a44ab3ee0
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 11 00:50:48 2020 +1000

    Delete game.jar

commit ef18d5bb3abe38a280feee5d861bd769296de5e5
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 23:54:52 2020 +1000

    1.2

commit f5e1a38286ac7c4ccc714e4f16669be9d57ef180
Merge: a4d1cb5 361f42e
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 23:53:49 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit a4d1cb56e2e3e2c29bf0823aeb8ec4b660b0e220
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 23:53:10 2020 +1000

    1.2

commit 361f42e9f8bacb5a49d412c2d147c084b12257cd
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 21:59:34 2020 +1000

    Add author detail for Luna and Birdy just in case we have merge issues

commit 3ce459cbadaee520edf234199c7ba270911c9a40
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 21:10:50 2020 +1000

    Update Jar
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit f35383302977143a67755ad61c9e53d25b51eb6f
Merge: 9ec280e 10a5244
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sun May 10 20:53:00 2020 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       game.jar

commit 9ec280eef701ac2a063c907181881f46410cf901
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 20:52:29 2020 +1000

    Update Jar
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 10a5244561f17918526988f52a9253820647a748
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 20:46:52 2020 +1000

    1.1

commit da25ba06f55b983fcb209a5a312672babfc154cd
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 20:43:57 2020 +1000

    signed my name

commit 6b756fc40c6de19c4809959df1a71cfe2e1fa283
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 20:43:14 2020 +1000

    Merge branch 'master' of /Users/birdy/IdeaProjects/comp1110-ass2-wed12a with conflicts.

commit 6eccfc5b45e7b064a05a72ee3cb5dd72d6d49192
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 10 20:33:41 2020 +1000

    Fixed my uid

commit 8443ecca5eb76cddb60744ef70ff10522c5f0ce0
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 10 20:31:49 2020 +1000

    Done task 7 and signed to the originality

commit d589af03853586856fa5b46355a652aa01110b02
Merge: 2b8f489 3957dbd
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 10 20:20:31 2020 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       admin/F-contribution.yml
    #       admin/F-originality.yml

commit 2b8f489cc517b024b7bfc015463cedd89e4be01e
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 10 20:19:38 2020 +1000

    Done task 7 and signed to the originality

commit 3957dbdcd3ee2f72d375f73148d9e90e402c1b0c
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 20:02:01 2020 +1000

    Use circle to replace square for players
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 0e57e743fe01f9ce867ea2e09d619f55a2674b12
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 18:27:03 2020 +1000

    Update D2F
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 995dc0ff4562161762eac4c4fd75ec825c990ed4
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 16:00:23 2020 +1000

    signed my name

commit 842d22d2c502ecaa934e35a7943f7b229a47a233
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:50:14 2020 +1000

    Modify F review - u6648214, u6864755 to pass CI

commit c3dbcc0e07025e1978eabe823a09984fda96a979
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:44:06 2020 +1000

    Add component
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit c31f8d9b98c1d2481b27f0d12ba082aa0c1375d1
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:41:49 2020 +1000

    Add Author to pass CI.
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 7e41f37827c2c84a1a878697e1be41db8a42173a
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:40:24 2020 +1000

    Add Object to pass CI.
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit a94d095465295511680b8574c2b0b9754ad310d2
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:38:36 2020 +1000

    Make everything comment in review to pass CI.
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 17cc9235d817f1e68657b16010b46194d30d412b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:35:07 2020 +1000

    It's cold outside. Please pass CI, final attempt.
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 07436e1722edcebaf3ad7588bfdbe37f1d8f28f5
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:25:02 2020 +1000

    Please pass CI attempt 3
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 129111ab45af67ca5cebb3c534df26738ce181f1
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:17:07 2020 +1000

    Please pass CI attempt 2
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit cf227185f57db31a802e440bc4d5ae754ab817b6
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 13:15:11 2020 +1000

    Please pass CI
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 4663bd3c5a20af382d6dd521f333fab1ff416236
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 11:54:27 2020 +1000

    Fix CI attempt n + 3
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit a8bd394377068b1ee59b7f1d6252dd02dfc793a2
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 11:51:27 2020 +1000

    Fix CI attempt n + 2
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit e6981e702e2ed53286be4657b4f1dd3269d93f7c
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 11:48:54 2020 +1000

    Fix CI attempt n+1
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 874b486cdd183ebd84a0a19a9a7579438fad9525
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 11:45:22 2020 +1000

    Update and fix CI attempt n
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 6f64c959da0efacbd2700a78c2697a7c7c00f09b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 11:40:11 2020 +1000

    Fix yml file CI
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 1487cadd15ed63873ebecb2ee7356de03a046138
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sun May 10 10:08:46 2020 +1000

    Fix CI attempt 4
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 88ed1c2870005826169529f8544b4e4b7200b751
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sun May 10 10:06:32 2020 +1000

    Fix CI attempt 3
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit 77a8305be508cb2f83fa4f3d94df6c620f773947
Merge: 84e68f3 d7ce0d9
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sun May 10 10:04:01 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 84e68f3ba5d67537e57edd5ae77e37a082fd7462
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 10:03:44 2020 +1000

    Update and fix CI
    
    Signed-off-by: u7020050 <u7020050@anu.edu.au>

commit d7ce0d9a7ad320a1a2b59ba3ce5b5297e6565d29
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 10 09:54:01 2020 +1000

    Fix CI

commit 209bdc018596cf5bc751790ea73143175536ac7f
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 00:59:23 2020 +1000

    signed my name

commit 32b3cf9052104bbe779da0517dbfe6d1ef469a9e
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 10 00:56:55 2020 +1000

    signed my name

commit ec74441a531f9023b01851a8da17f995f0c03c8b
Merge: e0c39da 5031bdb
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Sat May 9 15:18:19 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit e0c39dad07e09f7c28c8d062cebe6cdca8b71bde
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Sat May 9 15:17:47 2020 +1000

    Deliverable D2E Feedback

commit 5031bdb3b3d2f34692cc4989b89c95327c7edbe8
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Fri May 8 12:51:35 2020 +1000

    Update config for Game and game.jar

commit 152deb9de7c4b8a85aac6921d538f2c589006623
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Thu May 7 17:33:33 2020 +1000

    Update a running game.jar

commit 40356cbd728557aaeffe6b3cc05fd83ede6f6464
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Thu May 7 16:26:13 2020 +1000

    Backup push

commit 53c2c136a4d580fecfd272fdf59de05f488b8812
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:58:22 2020 +1000

    Update F-originality.yml

commit 9fa7e4fe5320a74fa28d5792718586dea2717380
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:56:26 2020 +1000

    Update F-contribution.yml

commit 8a7fd3d8e440ce5c3c8fa9e214ad63fb1f8a4100
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:56:12 2020 +1000

    Update F-contribution.yml

commit 0337ace58c381befcc61af393df593e9a536bab2
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:36:55 2020 +1000

    Add F review

commit fdf4df02af59f76c1b567172c98321d841761e5f
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:36:03 2020 +1000

    Add new file F-review

commit bc39ed2c30630e6b65c8392d9c508df0d53bc84b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed May 6 18:34:34 2020 +1000

    Add new file F-review-u7020050

commit 8203ee2a2738b1f91f107e1b088493d0dd20cb21
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 4 01:07:44 2020 +1000

    Change file name to pass CI - TileType

commit 809a725a5c9c71170df8482c528106d1fc29acae
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 4 01:04:59 2020 +1000

    Change file name to pass CI

commit 189a7acfd169829df3fbe36078a26cfc628613ec
Merge: 2d6b500 6c027f3
Author: u7020050 <u7020050@anu.edu.au>
Date:   Mon May 4 01:01:34 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 2d6b500f63b7100d72a9580486ac3ddcd9072968
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon May 4 01:01:18 2020 +1000

    Updated D2E - Yiwei

commit 6c027f367120a89ec2aaf039e70ea7c0926dbc0a
Author: Luna <u6648214@anu.edu.au>
Date:   Mon May 4 00:26:33 2020 +1000

    Made unit test and signed on originality

commit 400360463db678f360e9f5c28cb3f1a4baeb6ac1
Author: Luna <u6648214@anu.edu.au>
Date:   Mon May 4 00:23:31 2020 +1000

    Made unit test and signed on originality

commit d25c7f4facd2e507063a9779272b7bc0e1cd7d41
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 20:46:21 2020 +1000

    Delete B.java

commit 2fe8ec01b9206fde4988899f6c42e0ddfd914813
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 3 16:03:28 2020 +1000

    signed my name

commit 55b1a98770df87fc0ff5c65fa4dcbe0c4e46bb6a
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 3 13:09:42 2020 +1000

    add D2E originality

commit 452fdacb0f59eed795d8e75a64c1464e41546729
Merge: a2b9097 68bff9a
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 3 12:59:56 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit a2b9097f15aecf482f40627a43b06da9a9055b44
Author: birdy <u6864755@anu.edu.au>
Date:   Sun May 3 12:58:49 2020 +1000

    task3 complete 1.0

commit 68bff9a54a77a8180b492160de3d0c0c4e3e46cf
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 12:58:27 2020 +1000

    Delete E-originality-u6648214.yml

commit b24f0a48dec9ae7edd906b2971e465c392f70a44
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 12:31:08 2020 +1000

    Add D2E for 6648214

commit d48930cd2c81556313e9d7b31e60933ba230e30d
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 12:28:56 2020 +1000

    Add D2E for 6864755

commit 44cac22759ac8d00ef886bed014e024bb83edbd4
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 12:26:46 2020 +1000

    Add D2E for u6648214

commit 5651bb05eece5c6965319ce388f104fa8d06e3d4
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun May 3 12:22:41 2020 +1000

    Update E-originality-u7020050.yml

commit 3b2ce0e532e059739bd41c20440fac8057aa7887
Merge: ab61753 df7b0b8
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 3 12:05:19 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit ab617531b015833bcefd07c1e7e55345f37a63b0
Author: Luna <u6648214@anu.edu.au>
Date:   Sun May 3 12:05:09 2020 +1000

    Fix D2D CI

commit df7b0b8f4b90ba7f51d8345c8342afda0aa765b3
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Sun May 3 11:40:39 2020 +1000

    Deliverable D2D Feedback

commit ea87437b9ea80333390f26677d9eee516af7947a
Merge: 25324a6 1356ca1
Author: Luna <u6648214@anu.edu.au>
Date:   Wed Apr 29 18:51:01 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit 1356ca16e1da2e8ca4db3b4fe9e4f97b6d86ba2b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:50:27 2020 +1000

    Add new file

commit e485f787f9a5bf792790d86688d13129ecf6b38e
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:49:55 2020 +1000

    Add new file

commit 97e72b11f69669092900eb02ea84db66ec99a4b5
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:48:47 2020 +1000

    Add new file

commit bec62c87caedf6016a26ba2ba4a198156ddbc132
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:46:31 2020 +1000

    Add new file

commit cdd2e00e772580f42ee8dbee3eac5b9e191f6621
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:45:05 2020 +1000

    Add new file

commit a7b632758cccc5dadb96c6106f87b1c8ea4b560f
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:43:35 2020 +1000

    Update E-newcode-u1234567.md

commit a8f96906f93b7f64a1621f9a35da031f69353b71
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:41:48 2020 +1000

    Add new file - D2E

commit d2a8f0978fb11c2c3aaa31412b2f33e1f589334b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:40:34 2020 +1000

    Add new file - D2E

commit 5c4303249226cd4f188121d7da446ad5fb56538b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:38:22 2020 +1000

    Update E-originality-u1234567.yml

commit 25324a67bc8669108341cad58fc6c03264419fd3
Merge: bfda81e bc19fba
Author: Luna <u6648214@anu.edu.au>
Date:   Wed Apr 29 18:37:34 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit bc19fba8654912d38b8067fb258bbbbb336afd8b
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:36:08 2020 +1000

    Add new file to pass CI

commit 15b20c92af2e4285245f331669e64de35b3a6829
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:33:53 2020 +1000

    To pass CI

commit 99a8bf97583c23fe2e28936d8868e66ca640a181
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:31:53 2020 +1000

    Edit file name to pass CI

commit bfda81ee807089880b921ccf6bdaaae7101995d7
Merge: d52e726 676f1f9
Author: Luna <u6648214@anu.edu.au>
Date:   Wed Apr 29 18:26:45 2020 +1000

    Merge remote-tracking branch 'origin/master'
    
    # Conflicts:
    #       .idea/libraries/Maven__Arquillian_JUnit_Release.xml

commit d52e726e5733eb4d74b887f175bd7ac4c41478b3
Author: Luna <u6648214@anu.edu.au>
Date:   Wed Apr 29 18:26:08 2020 +1000

    Fix D2D CI

commit 676f1f9ca611671ba4a5af4a8f839222e3b7a675
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 29 18:19:32 2020 +1000

    Add new file

commit 869668899487caadad88c4bbc07a939a01fb17e3
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun Apr 26 00:16:39 2020 +1000

    Updated D2D new code (u7020050)

commit 9c9ef0d02e70f0f0379796aa5e12512f6e739a29
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sat Apr 25 23:56:07 2020 +1000

    Updated D2D originality to pass CI (u7020050)

commit 0407d0091b14eecd80a444520a0392603417011e
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sat Apr 25 23:53:03 2020 +1000

    Updated D2D code (u7020050)

commit 605bae3033bf74c9f42031c51f943739b708d5fb
Merge: de0f3a2 c01468d
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sat Apr 25 23:49:18 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit de0f3a2fcd62c84d249645bdd0f294e23ea330d5
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sat Apr 25 23:48:56 2020 +1000

    Updated D2D code (u7020050)

commit c01468dea0cea48bd7c2525b65469799491e2b22
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Fri Apr 24 19:58:25 2020 +1000

    Merged Task 9 with COMP1100(Don't know why last push didn't change this file.)

commit dd313b7b74a2086de091d7ce8bcc8acb5c97d3be
Merge: e9cc5cf 3fcfaa5
Author: u7020050 <u7020050@anu.edu.au>
Date:   Fri Apr 24 19:31:02 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit e9cc5cf18fc79b314e3a49cd17b669801af729f7
Merge: fe10141 b541bcf
Author: u7020050 <u7020050@anu.edu.au>
Date:   Fri Apr 24 19:29:00 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2
    
     Conflicts:
    	src/comp1110/ass2/Metro.java

commit b541bcf1225337f12c354b9501076ad05680999a
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 24 18:47:28 2020 +1000

    add new admin files for new individual code for D2D and D2E

commit e2e6899ca1afbe444edf99101010b40b95c39ca6
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Apr 24 18:37:05 2020 +1000

    remove hand parameter from Metro.generateMove
    
    This was not actually tested in the unit tests, and the way it was described was
    inconsistent with the rules of the game.
    Thanks for Evan Markou for noticing this.

commit 3fcfaa5275099cc69e600973c4f2a80308475dab
Merge: ebb2ee3 4b5168b
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Fri Apr 24 16:35:34 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit ebb2ee315fad9e1afb2b4b1e15a716025f164878
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Fri Apr 24 16:35:33 2020 +1000

    Deliverable D2C Feedback

commit fe1014172db2a73722d772c436327435060ffecc
Merge: 00a8329 4b5168b
Author: u7020050 <u7020050@anu.edu.au>
Date:   Wed Apr 22 14:20:02 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/u7020050/comp1110-ass2-wed12a

commit 4b5168ba02b0b8878d68dfa5362f522a30d2f7b0
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 22 14:16:17 2020 +1000

    Update D-originality-u7020050 (Yiwei)

commit 00a832912928b3d66a1296865146a5c1b0250d63
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Apr 22 14:12:44 2020 +1000

    Updated D2D Originality (u7020050)

commit a0508831f539f80e6e400993bf16babffdb7a7e7
Author: birdy <u6864755@anu.edu.au>
Date:   Wed Apr 22 13:10:07 2020 +1000

    task3 complete 1.0

commit d923bd3f9581e9d86de621c93fcf480f301cb662
Author: Rohan McLure <rohanmclure@gmail.com>
Date:   Tue Apr 21 08:04:30 2020 +1000

    D2C

commit 941464c5756c30ced73bbbea3c3523c8408922b6
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Sun Apr 19 12:08:41 2020 +1000

    Updated task 5

commit 8c952552c12ac98fde71f39ca44b2d4a44ca6546
Merge: 913c8d8 b44d4aa
Author: u7020050 <u7020050@anu.edu.au>
Date:   Tue Apr 14 18:39:26 2020 +1000

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2

commit b44d4aa3a6e23fa21d008973161d4d34d4f2b018
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Apr 14 09:12:21 2020 +1000

    IsPlacementSequenceValidTest: fix to one test for Rule 4 (was testing a different rule)
    
    GenerateMoveTest: fix two incorrect 'possible moves'
    
    Thanks to Zhichao Tu and Tian Wu for finding these bugs!

commit 913c8d81ed9c32778aab161dbf8294a58d4dc30d
Author: birdy <u6864755@anu.edu.au>
Date:   Mon Apr 13 18:45:26 2020 +1000

    task3 complete 1.0

commit fb3e1337f3b7a5e86da8cf772a6faa5f7d6bbbeb
Author: birdy <u6864755@anu.edu.au>
Date:   Mon Apr 13 18:02:38 2020 +1000

    task3 complete

commit 50a9463134860d83707960b2dfb1466913606368
Author: Luna <u6648214@anu.edu.au>
Date:   Fri Apr 10 11:16:14 2020 +1000

    signed to c originality

commit 8eddff7f073285efb824cee9696d8a5c7daed2b7
Merge: 02b0fd7 47fee77
Author: birdy <u6864755@anu.edu.au>
Date:   Fri Apr 10 11:05:20 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 02b0fd7e7e82fb16f80bb0faa94be8f84d0f8cc4
Author: birdy <u6864755@anu.edu.au>
Date:   Fri Apr 10 11:05:16 2020 +1000

    Merge branch 'master' of /Users/birdy/IdeaProjects/comp1110-ass2-wed12a with conflicts.

commit 47fee7764a4a7478cbeb343b038c5a42ec6699f9
Merge: 32ece76 8934faf
Author: u7020050 <u7020050@anu.edu.au>
Date:   Fri Apr 10 11:04:13 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 32ece76b6eb7c79b49f8de098700da25afdc84e3
Author: u7020050 <u7020050@anu.edu.au>
Date:   Fri Apr 10 11:03:51 2020 +1000

    Updated Task 4 to take longer String

commit 8934faf64c4af68aae844e6a55ce9e97ca550b08
Author: Luna <u6648214@anu.edu.au>
Date:   Fri Apr 10 10:47:25 2020 +1000

    Hide one code to commit

commit 73aff9c7cecd49d95c94c1e84e6991fd35e315e6
Author: Luna <u6648214@anu.edu.au>
Date:   Fri Apr 10 10:37:33 2020 +1000

    Signed the contribution

commit 6e155f35eee41fe483b2d4b65c81aa6826cf615c
Merge: 5327517 e704d8b
Author: Luna <u6648214@anu.edu.au>
Date:   Fri Apr 10 10:35:38 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit 532751776c782c02484ae90e423053863db5f8d4
Author: Luna <u6648214@anu.edu.au>
Date:   Fri Apr 10 10:35:34 2020 +1000

    Merge branch 'master' of C:\Users\pukur\IdeaProjects\comp1110-ass2-wed12a with conflicts.

commit e704d8bde1d56f98b9053e971a8e6696ed7cf91d
Author: birdy <u6864755@anu.edu.au>
Date:   Fri Apr 10 10:10:45 2020 +1000

    cindy

commit df28f57bce01c78b97edcc44d522200755e51934
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Tue Apr 7 22:22:00 2020 +1000

    Updated Task 4 and tasks.md

commit 4c35c6ee64eb0060194b3f0e2ba600a6604ec12c
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Tue Apr 7 22:02:51 2020 +1000

    Updated C-originality and C-contribution.yml

commit 3bb07da8b962be039bb6a9ff899c325507103400
Merge: ff37a24 0a2e778
Author: u7020050 <u7020050@anu.edu.au>
Date:   Tue Apr 7 21:58:09 2020 +1000

    Merge remote-tracking branch 'origin/master'

commit ff37a24c94ffbe9be408f8a2d5589cd16a9313bf
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Tue Apr 7 21:57:54 2020 +1000

    Updated Task 4.

commit 0a2e778f9a4a06224eed16f0267c4e573c4b8891
Merge: c8b52d3 c4df21c
Author: birdy <u6864755@anu.edu.au>
Date:   Wed Apr 1 18:40:44 2020 +1100

    Merge remote-tracking branch 'origin/master'

commit c8b52d3aff46ea074233ef532755d79610b4e1cc
Author: birdy <u6864755@anu.edu.au>
Date:   Wed Apr 1 18:36:29 2020 +1100

    cindy

commit c4df21cfa037674dc398529bef9afee5c56d0593
Author: Bob <u6648214@anu.edu.au>
Date:   Wed Apr 1 18:35:13 2020 +1100

    Done group

commit e8a6c099e0d9a86a011c32cb0ffbff7e3b17064c
Merge: 50b0860 f2eddd1
Author: Luna <u6648214@anu.edu.au>
Date:   Wed Apr 1 18:24:48 2020 +1100

    Merge remote-tracking branch 'origin/master'

commit f2eddd1f1b88302447ce5b69f865ff3f261c60d1
Author: Cindy <u6864755@anu.edu.au>
Date:   Wed Apr 1 18:24:03 2020 +1100

    cindy

commit 50b08601c832e03ca95e28ca81ff8a497c46b9d8
Author: Bob <u6648214@anu.edu.au>
Date:   Wed Apr 1 18:13:27 2020 +1100

    Fulfilled the originality

commit 9dfa421327bd5b3c44b80e75547a1ae073a43045
Merge: 8fb51c8 e1857e8
Author: u7020050 <u7020050@anu.edu.au>
Date:   Wed Apr 1 13:07:13 2020 +1100

    Merge remote-tracking branch 'origin/master'

commit 8fb51c8e90aea88fe1e3e50719b5efaa0a2f4fab
Author: u7020050 <u7020050@anu.edu.au>
Date:   Wed Apr 1 13:07:01 2020 +1100

    Gittest

commit e1857e81b6a05511878a9e343c85462e64113efa
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon Mar 30 22:51:17 2020 +1100

    Edited the Main Class part for SkeletonOverview.java

commit 3ce7f035f248d9067c6a9d95daf7c0a5a395ec6f
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Mon Mar 30 00:20:36 2020 +1100

    Update Main Class part for SkeletonOverview.java

commit d52c6c46ed1716758147a94edf324a36fe924bb9
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sun Mar 29 22:22:52 2020 +1100

    Added Game.fxml, CLass Game and updated Task 4

commit faf17126899ba7feedb49ac49818f4aedffe93db
Author: Shenwanyue Shang <u6864755@anu.edu.au>
Date:   Sun Mar 29 10:27:08 2020 +1100

    Update B-originality.yml

commit 356b026ed96460f9060fcc09769c5b2abd8210b0
Author: Shenwanyue Shang <u6864755@anu.edu.au>
Date:   Sun Mar 29 10:25:59 2020 +1100

    Update B-contribution.yml

commit 81e73e08ba257802c54b8f45606ebc5a21ab116b
Author: Shenwanyue Shang <u6864755@anu.edu.au>
Date:   Sun Mar 29 10:25:07 2020 +1100

    Update B-contribution.yml

commit a2c34cf1c930436d0b6126349f0e0737febc498c
Author: Runa Ebihara <u6648214@anu.edu.au>
Date:   Sun Mar 29 10:24:52 2020 +1100

    Update B-originality.yml

commit 2ac207035c4e1c5cfb88292f9262b0985491043d
Author: Runa Ebihara <u6648214@anu.edu.au>
Date:   Sun Mar 29 10:23:02 2020 +1100

    Update B-contribution.yml

commit 3e0c34ee719035f7b00bb70857e5103586d775e5
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sat Mar 28 14:46:35 2020 +1100

    Updated B-originality.yml to pass CI to update the master branch

commit 5943a5e9952f32bd1e6f629bb9709c80defa22c4
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sat Mar 28 14:42:06 2020 +1100

    Update B-Contribution and B-Originality to pass Compliance;Update with Master Branch

commit 73f1f23632aadb96bdd89a233109f361cedb5a82
Merge: d8de9f7 1f98ca5
Author: u7020050 <u7020050@anu.edu.au>
Date:   Sat Mar 28 14:32:48 2020 +1100

    Merge branch 'master' of https://gitlab.cecs.anu.edu.au/comp1110/comp1110-ass2
    
     Conflicts:
    	README.md

commit 1f98ca505f018a3c563965e257ecaf768a305676
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Mar 27 22:33:20 2020 +1100

    Task 5: add new parameter totalHands to Metro.drawFromDeck() to represent tiles in player hands
    
    Task 6: fix an incorrect test board string and documentation for Metro.isPlacementSequenceValid

commit d8de9f707df23fa9c0fd9f4f01c04c5c9602be08
Author: u7020050 <u7020050@anu.edu.au>
Date:   Fri Mar 27 21:10:12 2020 +1100

    Updated B-Originality, B-Contribution and SkeletonOverview

commit 12c1d1703bc7a92d72909fe33ca17c8cfb3bddb8
Author: Luna <u6648214@anu.edu.au>
Date:   Thu Mar 26 18:48:42 2020 +1100

    Finished task2

commit aa95f1cc8a0383bf0f7cbf438d7b4e1b2d8659a8
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Thu Mar 26 18:42:00 2020 +1100

    Replaced with the 3.20 README version.

commit c99c5bde4d91a591f0694f7e118b53bfe79f6619
Author: u7020050 <u7020050@anu.edu.au>
Date:   Mon Mar 23 22:01:41 2020 +1100

    Updated meeting time for week 5 in tasks.md

commit 17a0900365bb7b397bd0f3ee79443ed8d8fcd84d
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Fri Mar 20 20:48:51 2020 +1100

    fixes to README including correct enumeration of player stations

commit 62d1f3209ec748285adaf4f2548561ce1cc139f5
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Mar 18 13:42:48 2020 +1100

    Update tasks.md

commit e073c8732ccc30d0d45c3adb1ef277057be62edc
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Mar 18 13:40:23 2020 +1100

    Update members

commit 4d82737cd56c48ea58f6613c61284993c5ef67b9
Author: Yiwei Wu <yiwei.wu@anu.edu.au>
Date:   Wed Mar 18 13:38:18 2020 +1100

    Update members.yml

commit 9764e64113a3dc262e3bc1c41804c538f52abc2d
Author: Josh Milthorpe <josh.milthorpe@anu.edu.au>
Date:   Tue Mar 17 09:26:52 2020 +1100

    Initial commit
```
## Changes
``` diff
diff -ru -x .git ../master/comp1110-ass2/admin/B-contribution.yml comp1110-ass2/admin/B-contribution.yml
--- ../master/comp1110-ass2/admin/B-contribution.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/B-contribution.yml	2020-03-30 16:06:53.828357080 +1100
@@ -1,26 +1,26 @@
-# IMPORTANT: It is very important that you correctly complete this contribution
-# statement.
- 
-declaration: >-
-  We declare that the work toward our submission of Stage B was distributed among the group members as follows:
-
-# State your contributions as integers out of 100. The total contribution should
-# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
-# members).  
-contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+# IMPORTANT: It is very important that you correctly complete this contribution
+# statement.
+ 
+declaration: >-
+  We declare that the work toward our submission of Stage B was distributed among the group members as follows:
+
+# State your contributions as integers out of 100. The total contribution should
+# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
+# members).  
+contributions: 
+  - uid: u7020050
+    contribution: 33
+  - uid: u6648214
+    contribution: 33
+  - uid: u6864755
+    contribution: 33
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Runa Ebihara
+    uid: u6648214
+  - name: Birdy Shang
+    uid: u6864755
diff -ru -x .git ../master/comp1110-ass2/admin/B-originality.yml comp1110-ass2/admin/B-originality.yml
--- ../master/comp1110-ass2/admin/B-originality.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/B-originality.yml	2020-03-30 16:06:53.828357080 +1100
@@ -1,58 +1,55 @@
-# IMPORTANT: It is very important that you correctly complete this originality
-# statement.
-#
-# This is your statement of your submitted work being your own.
-# Incorrectly filling out this statement could lead to charges
-# of academic misconduct.
-# 
-# For information on how to fill this out correctly, see
-# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
-#
-
-declaration: >-
-  We declare that everything we have submitted for Stage B of this assignment
-  and all stages before it is entirely our own work, with the following
-  exceptions:
-
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
-
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members.)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+# IMPORTANT: It is very important that you correctly complete this originality
+# statement.
+#
+# This is your statement of your submitted work being your own.
+# Incorrectly filling out this statement could lead to charges
+# of academic misconduct.
+# 
+# For information on how to fill this out correctly, see
+# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
+#
+
+declaration: >-
+  We declare that everything we have submitted for Stage B of this assignment
+  and all stages before it is entirely our own work, with the following
+  exceptions:
+
+# Use this to list names of people who you collaborated with, and a
+# comment about what you collaborated on.
+#
+# Add as many "name+comment" entries as necessary
+# (or remove it altogether if you haven't collaborated with anyone)
+collaboration:
+  - name: TIAN WU
+    comment: He shared a metro card set so we can print out.
+
+# Use this to list any code that you used that you did not write,
+# aside from code provided by the lecturer.  Provide a comment
+# explaining your use and the URL to that code and the licence for
+# that code
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external code)
+
+
+# Use this to list any assets (artwork, sound, etc) that you used.
+# Provide a comment explaining your use of that asset and the URL
+# and license for the asset
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external assets)
+assets:
+  - comment: Metro Game IOS Version
+    url: None
+    licence: NA
+
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members.)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Runa Ebihara
+    uid: u6648214
+  - name: Birdy Shang
+    uid: u6864755
diff -ru -x .git ../master/comp1110-ass2/admin/C-contribution.yml comp1110-ass2/admin/C-contribution.yml
--- ../master/comp1110-ass2/admin/C-contribution.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/C-contribution.yml	2020-04-21 06:23:40.196582919 +1000
@@ -1,26 +1,26 @@
-# IMPORTANT: It is very important that you correctly complete this contribution
-# statement.
- 
-declaration: >-
-  We declare that the work toward our submission of Stage C was distributed among the group members as follows:
-
-# State your contributions as integers out of 100. The total contribution should
-# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
-# members).  
-contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+# IMPORTANT: It is very important that you correctly complete this contribution
+# statement.
+ 
+declaration: >-
+  We declare that the work toward our submission of Stage C was distributed among the group members as follows:
+
+# State your contributions as integers out of 100. The total contribution should
+# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
+# members).  
+contributions:
+  - uid: u7020050
+    contribution: 33
+  - uid: u6648214
+    contribution: 33
+  - uid: u6864755
+    contribution: 33
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Runa Ebihara
+    uid: u6648214
+  - name: Birdy Shang
+    uid: u6864755
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/C-originality.yml comp1110-ass2/admin/C-originality.yml
--- ../master/comp1110-ass2/admin/C-originality.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/C-originality.yml	2020-04-21 06:23:40.196582919 +1000
@@ -1,58 +1,47 @@
-# IMPORTANT: It is very important that you correctly complete this originality
-# statement.
-#
-# This is your statement of your submitted work being your own.
-# Incorrectly filling out this statement could lead to charges
-# of academic misconduct.
-# 
-# For information on how to fill this out correctly, see
-# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
-#
-
-declaration: >-
-  We declare that everything we have submitted for Stage C of this assignment
-  and all stages before it is entirely our own work, with the following
-  exceptions:
-
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
-
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members.)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+# IMPORTANT: It is very important that you correctly complete this originality
+# statement.
+#
+# This is your statement of your submitted work being your own.
+# Incorrectly filling out this statement could lead to charges
+# of academic misconduct.
+# 
+# For information on how to fill this out correctly, see
+# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
+#
+
+declaration: >-
+  We declare that everything we have submitted for Stage C of this assignment
+  and all stages before it is entirely our own work, with the following
+  exceptions:
+
+# Use this to list names of people who you collaborated with, and a
+# comment about what you collaborated on.
+#
+# Add as many "name+comment" entries as necessary
+# (or remove it altogether if you haven't collaborated with anyone)
+
+# Use this to list any code that you used that you did not write,
+# aside from code provided by the lecturer.  Provide a comment
+# explaining your use and the URL to that code and the licence for
+# that code
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external code)
+
+# Use this to list any assets (artwork, sound, etc) that you used.
+# Provide a comment explaining your use of that asset and the URL
+# and license for the asset
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external assets)
+
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members.)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Birdy Shang
+    uid: u6864755
+  - name: Runa Ebihara
+    uid: u6648214
Only in ../master/comp1110-ass2/admin: D-newcode-u1234567.md
Only in comp1110-ass2/admin: D-newcode-u7020050.md
Only in ../master/comp1110-ass2/admin: D-originality-u1234567.yml
Only in comp1110-ass2/admin: D-originality-u6648214.yml
Only in comp1110-ass2/admin: D-originality-u6864755.yml
Only in comp1110-ass2/admin: D-originality-u7020050.yml
Only in ../master/comp1110-ass2/admin: E-newcode-u1234567.md
Only in comp1110-ass2/admin: E-newcode-u6648214.md
Only in comp1110-ass2/admin: E-newcode-u6864755.md
Only in comp1110-ass2/admin: E-newcode-u7020050.md
Only in ../master/comp1110-ass2/admin: E-originality-u1234567.yml
Only in comp1110-ass2/admin: E-originality-u6648214.yml
Only in comp1110-ass2/admin: E-originality-u6864755.yml
Only in comp1110-ass2/admin: E-originality-u7020050.yml
diff -ru -x .git ../master/comp1110-ass2/admin/F-contribution.yml comp1110-ass2/admin/F-contribution.yml
--- ../master/comp1110-ass2/admin/F-contribution.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/F-contribution.yml	2020-05-11 07:49:42.579085387 +1000
@@ -1,26 +1,26 @@
-# IMPORTANT: It is very important that you correctly complete this contribution
-# statement.
- 
-declaration: >-
-  We declare that the work toward our submission of Stage F was distributed among the group members as follows:
-
-# State your contributions as integers out of 100. The total contribution should
-# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
-# members).  
-contributions:
-  - uid: 
-    contribution: 
-  - uid:
-    contribution:
-  - uid:
-    contribution:
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
\ No newline at end of file
+# IMPORTANT: It is very important that you correctly complete this contribution
+# statement.
+ 
+declaration: >-
+  We declare that the work toward our submission of Stage F was distributed among the group members as follows:
+
+# State your contributions as integers out of 100. The total contribution should
+# be 100 or 99 (33/33/33 is fine).  (Remove entries if you have fewer than three
+# members).  
+contributions:
+  - uid: u7020050
+    contribution: 33
+  - uid: u6648214
+    contribution: 33
+  - uid: u6864755
+    contribution: 33
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Birdy Shang
+    uid: u6864755
+  - name: Runa Ebihara
+    uid: u6648214
\ No newline at end of file
diff -ru -x .git ../master/comp1110-ass2/admin/F-originality.yml comp1110-ass2/admin/F-originality.yml
--- ../master/comp1110-ass2/admin/F-originality.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/F-originality.yml	2020-05-11 07:49:42.579085387 +1000
@@ -1,58 +1,58 @@
-# IMPORTANT: It is very important that you correctly complete this originality
-# statement.
-#
-# This is your statement of your submitted work being your own.
-# Incorrectly filling out this statement could lead to charges
-# of academic misconduct.
-# 
-# For information on how to fill this out correctly, see
-# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
-#
-
-declaration: >-
-  We declare that everything we have submitted for Stage F of this assignment
-  and all stages before it is entirely our own work, with the following
-  exceptions:
-
-# Use this to list names of people who you collaborated with, and a
-# comment about what you collaborated on.
-#
-# Add as many "name+comment" entries as necessary
-# (or remove it altogether if you haven't collaborated with anyone)
-collaboration:
-  - name:
-    comment: >-
-
-# Use this to list any code that you used that you did not write,
-# aside from code provided by the lecturer.  Provide a comment
-# explaining your use and the URL to that code and the licence for
-# that code
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external code)
-code:
-  - comment:
-    url:
-    licence:
-
-# Use this to list any assets (artwork, sound, etc) that you used.
-# Provide a comment explaining your use of that asset and the URL
-# and license for the asset
-#
-# Add as many "url+licence+comment" entries as necessary
-# (or remove it altogether if you haven't used any external assets)
-assets:
-  - comment:
-    url:
-    licence:
-
-
-# Sign *your* name and uids here. (Remove entries if you have fewer
-# than three members.)
-signatures:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+# IMPORTANT: It is very important that you correctly complete this originality
+# statement.
+#
+# This is your statement of your submitted work being your own.
+# Incorrectly filling out this statement could lead to charges
+# of academic misconduct.
+# 
+# For information on how to fill this out correctly, see
+# https://cs.anu.edu.au/courses/comp1110/help/faq/09-originality/
+#
+
+declaration: >-
+  We declare that everything we have submitted for Stage F of this assignment
+  and all stages before it is entirely our own work, with the following
+  exceptions:
+
+# Use this to list names of people who you collaborated with, and a
+# comment about what you collaborated on.
+#
+# Add as many "name+comment" entries as necessary
+# (or remove it altogether if you haven't collaborated with anyone)
+
+# Use this to list any code that you used that you did not write,
+# aside from code provided by the lecturer.  Provide a comment
+# explaining your use and the URL to that code and the licence for
+# that code
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external code)
+
+# Use this to list any assets (artwork, sound, etc) that you used.
+# Provide a comment explaining your use of that asset and the URL
+# and license for the asset
+#
+# Add as many "url+licence+comment" entries as necessary
+# (or remove it altogether if you haven't used any external assets)
+assets:
+  - comment: Images for players
+    url: https://www.pinterest.com.au/cheryldctn/impressionist-portrait/
+    licence: Photo
+
+  - comment: Enum type
+    url: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
+    licence: https://www.oracle.com/legal/terms.html
+
+  - comment: Substring
+    url: https://docs.oracle.com/javase/tutorial/java/data/manipstrings.html
+    licence: https://www.oracle.com/legal/terms.html
+
+# Sign *your* name and uids here. (Remove entries if you have fewer
+# than three members.)
+signatures:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Birdy Shang
+    uid: u6864755
+  - name: Runa Ebihara
+    uid: u6648214
Only in ../master/comp1110-ass2/admin: F-review-u1234567.yml
Only in comp1110-ass2/admin: F-review-u6648214.yml
Only in comp1110-ass2/admin: F-review-u6864755.yml
Only in comp1110-ass2/admin: F-review-u7020050.yml
Only in ../master/comp1110-ass2/admin: H-presentation.yml
diff -ru -x .git ../master/comp1110-ass2/admin/members.yml comp1110-ass2/admin/members.yml
--- ../master/comp1110-ass2/admin/members.yml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/members.yml	2020-03-30 16:06:53.828357080 +1100
@@ -1,11 +1,11 @@
-# List the membership of this group.  (Remove entries if you have fewer
-# than three members.)
-#
-
-members:
-  - name:
-    uid:
-  - name:
-    uid:
-  - name:
-    uid:
+# List the membership of this group.  (Remove entries if you have fewer
+# than three members.)
+#
+
+members:
+  - name: Yiwei Wu
+    uid: u7020050
+  - name: Runa Ebihara
+    uid: u6648214
+  - name: Shengwanyue Shang
+    uid: u6864755
diff -ru -x .git ../master/comp1110-ass2/admin/tasks.md comp1110-ass2/admin/tasks.md
--- ../master/comp1110-ass2/admin/tasks.md	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/admin/tasks.md	2020-04-21 06:23:40.196582919 +1000
@@ -1,32 +1,37 @@
-# COMP1110 Assignment 2 Group Tasks
-
-For each task or sub-task, record who is responsible, the deadline, and any dependencies.
-Use the entries below as an example.
-
-## Week 4
-
-Everyone: create application skeleton - meeting 14:00 20 Mar
-
-## Week 5
-
-Zhang San: Task 3 isPiecePlacementWellFormed - 26 Mar
-
-Jane Bloggs: Task 4 getNeighbours - 27 Mar
-
-Erika Mustermann: Task 6 getViablePiecePlacements - 28 Mar (depends on Task 3)
-
-## Week 6
-
-...
-
-## Mid-Semester Break
-
-## Week 7
-
-## Week 8
-
-## Week 9
-
-## Week 10
-
-## Week 11
+# COMP1110 Assignment 2 Group Tasks
+
+For each task or sub-task, record who is responsible, the deadline, and any dependencies.
+Use the entries below as an example.
+
+## Week 4
+
+Everyone: create application skeleton - meeting 10:00 Mar 24th
+
+## Week 5
+Group Meeting - Wed 18.00 pm
+
+Yiwei - Sort out skeleton based on group discussion
+
+Luna - Task 2
+
+Birdy - Task 3
+
+## Mid-Semester Break
+
+Break Week 1
+
+Yiwei - Task 4
+
+Luna - Task 5
+
+Birdy - Task 3
+
+## Week 7
+
+## Week 8
+
+## Week 9
+
+## Week 10
+
+## Week 11
diff -ru -x .git ../master/comp1110-ass2/comp1110-ass2.iml comp1110-ass2/comp1110-ass2.iml
--- ../master/comp1110-ass2/comp1110-ass2.iml	2020-04-27 18:58:35.729962734 +1000
+++ comp1110-ass2/comp1110-ass2.iml	2020-05-04 21:34:59.691348583 +1000
@@ -19,5 +19,42 @@
         <SOURCES />
       </library>
     </orderEntry>
+    <orderEntry type="module-library" scope="TEST">
+      <library name="JUnit4">
+        <CLASSES>
+          <root url="jar://$MAVEN_REPOSITORY$/junit/junit/4.12/junit-4.12.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
+    <orderEntry type="library" name="Maven: Arquillian JUnit:Release" level="project" />
+    <orderEntry type="module-library" scope="TEST">
+      <library name="JUnit4">
+        <CLASSES>
+          <root url="jar://$MAVEN_REPOSITORY$/junit/junit/4.12/junit-4.12.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
+    <orderEntry type="module-library" scope="TEST">
+      <library name="JUnit5.4">
+        <CLASSES>
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/jupiter/junit-jupiter/5.4.2/junit-jupiter-5.4.2.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/jupiter/junit-jupiter-api/5.4.2/junit-jupiter-api-5.4.2.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/apiguardian/apiguardian-api/1.0.0/apiguardian-api-1.0.0.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/opentest4j/opentest4j/1.1.1/opentest4j-1.1.1.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/platform/junit-platform-commons/1.4.2/junit-platform-commons-1.4.2.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/jupiter/junit-jupiter-params/5.4.2/junit-jupiter-params-5.4.2.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/jupiter/junit-jupiter-engine/5.4.2/junit-jupiter-engine-5.4.2.jar!/" />
+          <root url="jar://$MAVEN_REPOSITORY$/org/junit/platform/junit-platform-engine/1.4.2/junit-platform-engine-1.4.2.jar!/" />
+        </CLASSES>
+        <JAVADOC />
+        <SOURCES />
+      </library>
+    </orderEntry>
   </component>
 </module>
\ No newline at end of file
Only in comp1110-ass2: feedback
Only in comp1110-ass2: feedback.md
Only in comp1110-ass2: game.jar
diff -ru -x .git ../master/comp1110-ass2/.gitignore comp1110-ass2/.gitignore
--- ../master/comp1110-ass2/.gitignore	2020-04-27 18:58:35.649963280 +1000
+++ comp1110-ass2/.gitignore	2020-05-11 07:49:42.579085387 +1000
@@ -10,6 +10,7 @@
 .idea/markdown-navigator.xml
 .idea/markdown-navigator-enh.xml
 .idea/vcs.xml
+
 .idea/workspace.xml
 .idea/compiler.xml
 .idea/copyright/
Only in comp1110-ass2/.idea: artifacts
Only in comp1110-ass2/.idea: checkstyle-idea.xml
Only in comp1110-ass2/.idea: dictionaries
Only in comp1110-ass2/.idea/libraries: Maven__Arquillian_JUnit_Release.xml
diff -ru -x .git ../master/comp1110-ass2/.idea/misc.xml comp1110-ass2/.idea/misc.xml
--- ../master/comp1110-ass2/.idea/misc.xml	2020-04-27 18:58:35.653963253 +1000
+++ comp1110-ass2/.idea/misc.xml	2020-03-30 16:06:53.828357080 +1100
@@ -1,6 +1,6 @@
 <?xml version="1.0" encoding="UTF-8"?>
 <project version="4">
-  <component name="ProjectRootManager" version="2" languageLevel="JDK_13" default="true" project-jdk-name="13" project-jdk-type="JavaSDK">
+  <component name="ProjectRootManager" version="2" languageLevel="JDK_13" default="false" project-jdk-name="13" project-jdk-type="JavaSDK">
     <output url="file://$PROJECT_DIR$/out" />
   </component>
 </project>
\ No newline at end of file
Only in comp1110-ass2/.idea: vcs.xml
Only in comp1110-ass2/.idea: workspace.xml
Only in comp1110-ass2: markertmp
Only in comp1110-ass2: META-INF
Only in comp1110-ass2: out
diff -ru -x .git ../master/comp1110-ass2/README.md comp1110-ass2/README.md
--- ../master/comp1110-ass2/README.md	2020-05-29 13:44:00.520497777 +1000
+++ comp1110-ass2/README.md	2020-03-30 16:06:53.828357080 +1100
@@ -1,283 +1,283 @@
-# COMP1110 Assignment 2 S1 2020 - Metro
-
-## Academic Honesty and Integrity
-
-Honesty and integrity are of utmost importance.
-These goals are *not* at odds with being resourceful and working collaboratively.
-You *should* be resourceful, you should collaborate within your team, and you should discuss the assignment and other aspects of the course with others taking the class.
-However, *you must never misrepresent the work of others as your own*.
-If you have taken ideas from elsewhere or used code sourced from elsewhere, you must say so with *utmost clarity*.
-At each stage of the assignment you will be asked to submit a statement of originality, either as a group or as individuals.
-This statement is the place for you to declare which ideas or code contained in your submission were sourced from elsewhere.
-
-Please read the ANU's [official position](http://academichonesty.anu.edu.au/) on academic honesty.
-If you have any questions, please ask me.
-
-Carefully review the [statement of originality](originality.md) which you must complete.
-Edit that statement and update it as you complete each state of the assignment, ensuring that when you complete each stage, a truthful statement is committed and pushed to your repo.
-
-## Purpose
-
-In this assignment you will exercise a number of major themes of the course, including software design and implementation,
-using development tools such as Git and IntelliJ, using JavaFX to build a user interface.
-As an extension task, you may also explore strategies for writing agents that play games.
-Above all, this assignment will emphasize group work.
-
-
-## Assignment Deliverables
-
-The assignment is worth 30% of your total assessment, and it will be marked out of 30.
-So each mark in the assignment corresponds to a mark in your final assessment for the course.
-Note that for some stages of the assignment you will get a _group_ mark, and for others you will be _individually_ marked.
-The mark breakdown and the due dates are described on the [deliverables](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/) page.
-
-Your work will be marked by your tutor against the work you push to GitLab, so it is essential that you carefully follow instructions for setting up and maintaining your group repository.
-At each deadline you will be marked according to whatever is pushed to GitLab at the time of the deadline.
-You will be assessed on how effectively you use Git as a development tool.
-
-
-## Problem Description
-
-Your task is to implement in Java, using JavaFX, a tile placement game called [*Metro*](https://www.ultraboardgames.com/metro/game-rules.php),
-made by games developer Dirk Henn and published by [Queen Games](https://ssl.queen-games.com/en/start_en/). 
-[Board Game Geek provides a description of Metro](https://boardgamegeek.com/boardgame/559/metro), including images of the components.
-
-
-### Rules
-
-Metro is a game for 2-6 players, who take turns placing tiles.
-First, the deck is shuffled so that the tiles are drawn in a random order.
-Each player starts with an empty hand.
-
-On their turn, a player draws a tile (if they do not currently have one in their hand), then they place the tile on the board.
-If they do not wish to place the tile, they may pick up another tile from the deck *which they must place immediately*.
-On their following turn, they have the option to place the tile in their hand, or again draw from the deck. 
-On any given turn, if a player chooses to draw from the deck when they *already have a tile in their hand*,
-they *must place the tile that they draw*.
-
-There are four conditions that must be followed when laying down tiles:
-
-* Each tile must be placed on a square adjacent to another tile or the edge of the board.
-  A tile may not be placed next to one of the central station tiles unless it is also adjacent to another tile.
-* Tiles cannot be rotated.
-* A tile may be placed against any other player's metro line or station. 
-* A tile may not be placed so that it connects two stations (or loops back to the same station) with a track of length 1, unless there is no other valid way to place this tile (this rarely occurs). 
-
-The game ends when all tiles have been placed.
-The winner is decided by scoring completed tracks - see [Scoring](#scoring).
-
-The image below shows invalid placements that may occur.
-The tile in the top-left corner is invalid because it completes a track from station 9 with a length of 1.
-The tile in the top-right corner is invalid because it loops from station 6 back to itself, when there are other options available for placement.
-The tile in the bottom-centre is invalid because it does not connect to any other tile or the edge of the board.
-
-![Example of invalid placement](assets/invalid_placements.png)
-
-The following image demonstrates *valid* loops from a station back to itself.
-Note the invalid loops traverse only one tile, while the valid loops traverse more than one tile.
-
-![Example of valid loops](assets/valid_lines.png)
-
-### Board
-
-Tiles are placed on a board of 8x8 squares, labelled 0-7 across the rows and columns.
-Each square is labelled `(row, column)` or equivalently `(y,x)`.
-Around the edges of the board are *stations*, which are numbered 1 to 32 starting in the top right corner and continuing anticlockwise.
-Which edge stations belong to each player depends on the number of players in the game; the station arrangements for 2-6 players
-are as follows:
-
-- 2 players:
-  - player 1 owns 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31
-  - player 2 owns 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32
-- 3 players:
-  - player 1 owns 1, 4, 6, 11, 15, 20, 23, 25, 28, 31
-  - player 2 owns 2, 7, 9, 12, 14, 19, 22, 27, 29, 32
-  - player 3 owns 3, 5, 8, 10, 13, 18, 21, 24, 26, 30
-- 4 players:
-  - player 1 owns 4, 7, 11, 16, 20, 23, 27, 32
-  - player 2 owns 3, 8, 12, 15, 19, 24, 28, 31
-  - player 3 owns 1, 6, 10, 13, 18, 21, 25, 30
-  - player 4 owns 2, 5,  9, 14, 17, 22, 26, 29
-- 5 players:
-  - player 1 owns 1, 5, 10, 14, 22, 28
-  - player 2 owns 6, 12, 18, 23, 27, 32
-  - player 3 owns 3, 7, 15, 19, 25, 29
-  - player 4 owns 2, 9, 13, 21, 26, 30
-  - player 5 owns 4, 8, 11, 20, 24, 31
-- 6 players:
-  - player 1 owns 1, 5, 10, 19, 27
-  - player 2 owns 2, 11, 18, 25, 29
-  - player 3 owns 4, 8, 14, 21, 26
-  - player 4 owns 6, 15, 20, 24, 31
-  - player 5 owns 3, 9, 13, 23, 30
-  - player 6 owns 7, 12, 22, 28, 32
-
-There are also four stations located in the centre of the board at coordinates `(3,3), (3,4), (4,3), (4,4)`.
-These belong to no player, but double the score of any line that ends at them.
-
-The image below shows the layout of the board, including the label of each square.
-![Board positions](assets/board_positions.png)
-
-
-### Tiles
-
-Tiles have 8 exits, starting with 0 in the top-left corner and continuing clockwise as shown below.
-Each even-numbered exit connects to an odd-numbered exit.
-
-![Example tile showing number of each exit, starting with 0 in the top-left and continuing clockwise](assets/numbered_exits.png)
-
-Every tile is represented by a four-character string. 
-Each character is a letter between 'a' and 'd', denoting the **orientation of the
-tracks leading from even-numbered exits on each side of the tile**, starting at exit 0 and moving clockwise.
-More specifically,
-
-* 'a' denotes a straight track;
-* 'b' denotes a track that turns 90º to the neighbouring edge clockwise;
-* 'c' denotes a track that turns 90º to the neighbouring edge counter-clockwise; and,
-* 'd' denotes a track that turns 180º i.e. loops back to the same edge.
-
-The image below shows the tile 'cbaa', which has a track from exit 0 that turns counter-clockwise to join exit 7, a track from exit 2 that turns to clockwise to join exit 5, a straight track from exit 4 to exit 1, and a straight track from exit 6 to exit 3.
-
-![Example tile cbaa showing labels of even-numbered exits, starting with c at exit 0 and continuing clockwise](assets/tile_label.png)
-
-There are 60 tiles in total, with 2-4 copies of each tile as follows: 
-* **4 copies** of tiles `aacb`, `cbaa`, `acba`, `baac`, and `aaaa`;
-* **3 copies** of tiles `cbcb` and `bcbc`; and,
-* **2 copies** of all remaining tiles: `cccc`, `bbbb`, `dacc`, `cdac`, `ccda`, `accd`, `dbba`, `adbb`, `badb`, `bbad`, `ddbc`, `cddb`, `bcdd`, `dbcd`, `adad`, `dada` and `dddd`.
-
-Individual images of each tile can be found in `src/gui/assets`.
-
-### Tile Placements
-
-A *tile placement* string is a six character string, the first four characters of which represent a [tile](#tiles).
-The final two characters are digits between 0 and 7 denoting the row and column of the tile (in that order).
-For example, the tile `cccc` in row 3, column 2 would be labelled `cccc32`. 
-
-A *placement sequence* string is a concatenation of up to 60 tile placement strings, representing all tiles that have been placed so far in a game.
-
-### Scoring
-
-
-Any metro lines that start at a player's station and end at a station score points. 
-A player scores 1 point *for each tile the metro line crosses.* If a metro line crosses a tile *more than once*, then the player
-scores 1 point for *every time that line crosses the tile.* If a line ends at one of the central stations,
-the points for that line are doubled. 
-
-For example: In the image below, the yellow player scores 19 points on station 11.
-(Remember tracks can finish at any station, this one just happens to loop back to itself).
-
-![Example track scoring](assets/scoring_example_1.png)
-
-
-## Legal and Ethical Issues
-
-First, as with any work you do, you must abide by the principles of
-[honesty and integrity](http://academichonesty.anu.edu.au). You are
-expected to demonstrate honesty and integrity in everything you do.
-
-In addition to those ground rules, you are to follow the rules one
-would normally be subject to in a commercial setting. In particular,
-you may make use of the works of others under two fundamental
-conditions: a) your use of their work must be clearly acknowledged,
-and b) your use of their work must be legal (for example, consistent
-with any copyright and licensing that applies to the given
-material). *Please understand that violation of these rules is a very
-serious offence.* However, as long as you abide by these rules, you
-are explicitly invited to conduct research and make use of a variety
-of sources. You are also given an explicit means with which to declare
-your use of other sources (via originality statements you must
-complete). It is important to realize that you will be assessed on the
-basis of your original contributions to the project. While you won't
-be penalized for correctly attributed use of others' ideas, the work
-of others will not be considered as part of your
-contribution. Therefore, these rules allow you to copy another
-student's work entirely if: a) they gave you permission to do so, and
-b) you acknowledged that you had done so. Notice, however, that if you
-were to do this you would have no original contribution and so would
-receive no marks for the assignment (but you would not have broken any
-rules either).
-
-## Evaluation Criteria
-
-It is essential that you refer to the
-[deliverables page](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/)
-to check that you understand each of the deadlines and what is
-required.  Your assignment will be marked via tests run through GitLab's
-continuous integration (CI) framework, so all submittable materials
-will need to be in GitLab and in the *correct* locations, as prescribed
-by the
-[deliverables page](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/).
-
-
-**The mark breakdown is described on the
-[deliverables](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/)
-page.**
-
-### Part One
-
-In the first part of the assignment you will:
-* Implement parts of the text interface to the game (Tasks #2 and #3).
-* Implement a simple viewer that allows you to visualize game states (Task #4).
-
-The criteria for the [completion of part one](https://gitlab.cecs.anu.edu.au/comp1110/comp1110/wikis/deliverables#d2c-assignment-2-stage-c-2-marks-group) are as follows:
-
-<a name="p"></a>
-**Pass**
-* Tasks #2 and #3
-
-<a name="cr"></a>
-**Credit**
-* Task #4 *(in addition to all tasks required for Pass)*
-
-<a name="d"></a>
-**Distinction**
-* Task #5 *(in addition to all tasks required for Credit)*
-
-### Part Two
-
-Create a fully working game, using JavaFX to implement a playable
-graphical version of the game in a 1024x768 window.
-
-Notice that aside from the window size, the details of exactly how the
-game looks etc. are **intentionally** left up to you.  The diagrams
-above are for illustration purposes only, although you are welcome to
-use all of the resources provided in this repo, including the bitmap
-images.
-
-The only **firm** requirements are that:
-
-* you use Java and JavaFX,
-* the game respects the specification given here,
-* the game be easy to play,
-* it runs in a 1024x768 window, and
-* that it is executable on a standard lab machine from a JAR file called `game.jar`,
-
-Your game must successfully run from `game.jar` from within another
-user's (i.e.  your tutor's) account on a standard lab machine.
-In other words, your game must not depend on features not self-contained
-within that JAR file and the Java 13 runtime.
-
-<a name="2p"></a>
-**Pass**
-* Correctly implements all of the <b>Part One</b> criteria.
-* Appropriate use of git (as demonstrated by the history of your repo).
-* Completion of Task #6 and #7
-* Executable on a standard lab computer from a runnable JAR file,
-  game.jar, which resides in the root level of your group repo.
-
-<a name="2c"></a>
-**Credit**
-* _All of the Pass-level criteria, plus the following..._
-* Task #8
-
-<a name="2d"></a>
-**Distinction**
-* _All of the Credit-level criteria, plus the following..._
-* Tasks #9 and #10
-
-<a name="2hd"></a>
-**High Distinction**
-* _All of the Distinction-level criteria, plus the following..._
-* Tasks #11 and #12
-
-
+# COMP1110 Assignment 2 S1 2020 - Metro
+
+## Academic Honesty and Integrity
+
+Honesty and integrity are of utmost importance.
+These goals are *not* at odds with being resourceful and working collaboratively.
+You *should* be resourceful, you should collaborate within your team, and you should discuss the assignment and other aspects of the course with others taking the class.
+However, *you must never misrepresent the work of others as your own*.
+If you have taken ideas from elsewhere or used code sourced from elsewhere, you must say so with *utmost clarity*.
+At each stage of the assignment you will be asked to submit a statement of originality, either as a group or as individuals.
+This statement is the place for you to declare which ideas or code contained in your submission were sourced from elsewhere.
+
+Please read the ANU's [official position](http://academichonesty.anu.edu.au/) on academic honesty.
+If you have any questions, please ask me.
+
+Carefully review the [statement of originality](originality.md) which you must complete.
+Edit that statement and update it as you complete each state of the assignment, ensuring that when you complete each stage, a truthful statement is committed and pushed to your repo.
+
+## Purpose
+
+In this assignment you will exercise a number of major themes of the course, including software design and implementation,
+using development tools such as Git and IntelliJ, using JavaFX to build a user interface.
+As an extension task, you may also explore strategies for writing agents that play games.
+Above all, this assignment will emphasize group work.
+
+
+## Assignment Deliverables
+
+The assignment is worth 30% of your total assessment, and it will be marked out of 30.
+So each mark in the assignment corresponds to a mark in your final assessment for the course.
+Note that for some stages of the assignment you will get a _group_ mark, and for others you will be _individually_ marked.
+The mark breakdown and the due dates are described on the [deliverables](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/) page.
+
+Your work will be marked by your tutor against the work you push to GitLab, so it is essential that you carefully follow instructions for setting up and maintaining your group repository.
+At each deadline you will be marked according to whatever is pushed to GitLab at the time of the deadline.
+You will be assessed on how effectively you use Git as a development tool.
+
+
+## Problem Description
+
+Your task is to implement in Java, using JavaFX, a tile placement game called [*Metro*](https://www.ultraboardgames.com/metro/game-rules.php),
+made by games developer Dirk Henn and published by [Queen Games](https://ssl.queen-games.com/en/start_en/). 
+[Board Game Geek provides a description of Metro](https://boardgamegeek.com/boardgame/559/metro), including images of the components.
+
+
+### Rules
+
+Metro is a game for 2-6 players, who take turns placing tiles.
+First, the deck is shuffled so that the tiles are drawn in a random order.
+Each player starts with an empty hand.
+
+On their turn, a player draws a tile (if they do not currently have one in their hand), then they place the tile on the board.
+If they do not wish to place the tile, they may pick up another tile from the deck *which they must place immediately*.
+On their following turn, they have the option to place the tile in their hand, or again draw from the deck. 
+On any given turn, if a player chooses to draw from the deck when they *already have a tile in their hand*,
+they *must place the tile that they draw*.
+
+There are four conditions that must be followed when laying down tiles:
+
+* Each tile must be placed on a square adjacent to another tile or the edge of the board.
+  A tile may not be placed next to one of the central station tiles unless it is also adjacent to another tile.
+* Tiles cannot be rotated.
+* A tile may be placed against any other player's metro line or station. 
+* A tile may not be placed so that it connects two stations (or loops back to the same station) with a track of length 1, unless there is no other valid way to place this tile (this rarely occurs). 
+
+The game ends when all tiles have been placed.
+The winner is decided by scoring completed tracks - see [Scoring](#scoring).
+
+The image below shows invalid placements that may occur.
+The tile in the top-left corner is invalid because it completes a track from station 9 with a length of 1.
+The tile in the top-right corner is invalid because it loops from station 6 back to itself, when there are other options available for placement.
+The tile in the bottom-centre is invalid because it does not connect to any other tile or the edge of the board.
+
+![Example of invalid placement](assets/invalid_placements.png)
+
+The following image demonstrates *valid* loops from a station back to itself.
+Note the invalid loops traverse only one tile, while the valid loops traverse more than one tile.
+
+![Example of valid loops](assets/valid_lines.png)
+
+### Board
+
+Tiles are placed on a board of 8x8 squares, labelled 0-7 across the rows and columns.
+Each square is labelled `(row, column)` or equivalently `(y,x)`.
+Around the edges of the board are *stations*, which are numbered 1 to 32 starting in the top right corner and continuing anticlockwise.
+Which edge stations belong to each player depends on the number of players in the game; the station arrangements for 2-6 players
+are as follows:
+
+- 2 players:
+  - player 1 owns 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31
+  - player 2 owns 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32
+- 3 players:
+  - player 1 owns 1, 4, 6, 11, 15, 20, 23, 25, 28, 31
+  - player 2 owns 2, 7, 9, 12, 14, 19, 22, 27, 29, 32
+  - player 3 owns 3, 5, 8, 10, 13, 18, 21, 24, 26, 30
+- 4 players:
+  - player 1 owns 4, 7, 11, 16, 20, 23, 27, 32
+  - player 2 owns 3, 8, 12, 15, 19, 24, 28, 31
+  - player 3 owns 1, 6, 10, 13, 18, 21, 25, 30
+  - player 4 owns 2, 5,  9, 14, 17, 22, 26, 29
+- 5 players:
+  - player 1 owns 1, 5, 10, 14, 22, 28
+  - player 2 owns 6, 12, 18, 23, 27, 32
+  - player 3 owns 3, 7, 15, 19, 25, 29
+  - player 4 owns 2, 9, 13, 21, 26, 30
+  - player 5 owns 4, 8, 11, 20, 24, 31
+- 6 players:
+  - player 1 owns 1, 5, 10, 19, 27
+  - player 2 owns 2, 11, 18, 25, 29
+  - player 3 owns 4, 8, 14, 21, 26
+  - player 4 owns 6, 15, 20, 24, 31
+  - player 5 owns 3, 9, 13, 23, 30
+  - player 6 owns 7, 12, 22, 28, 32
+
+There are also four stations located in the centre of the board at coordinates `(3,3), (3,4), (4,3), (4,4)`.
+These belong to no player, but double the score of any line that ends at them.
+
+The image below shows the layout of the board, including the label of each square.
+![Board positions](assets/board_positions.png)
+
+
+### Tiles
+
+Tiles have 8 exits, starting with 0 in the top-left corner and continuing clockwise as shown below.
+Each even-numbered exit connects to an odd-numbered exit.
+
+![Example tile showing number of each exit, starting with 0 in the top-left and continuing clockwise](assets/numbered_exits.png)
+
+Every tile is represented by a four-character string. 
+Each character is a letter between 'a' and 'd', denoting the **orientation of the
+tracks leading from even-numbered exits on each side of the tile**, starting at exit 0 and moving clockwise.
+More specifically,
+
+* 'a' denotes a straight track;
+* 'b' denotes a track that turns 90º to the neighbouring edge clockwise;
+* 'c' denotes a track that turns 90º to the neighbouring edge counter-clockwise; and,
+* 'd' denotes a track that turns 180º i.e. loops back to the same edge.
+
+The image below shows the tile 'cbaa', which has a track from exit 0 that turns counter-clockwise to join exit 7, a track from exit 2 that turns to clockwise to join exit 5, a straight track from exit 4 to exit 1, and a straight track from exit 6 to exit 3.
+
+![Example tile cbaa showing labels of even-numbered exits, starting with c at exit 0 and continuing clockwise](assets/tile_label.png)
+
+There are 60 tiles in total, with 2-4 copies of each tile as follows: 
+* **4 copies** of tiles `aacb`, `cbaa`, `acba`, `baac`, and `aaaa`;
+* **3 copies** of tiles `cbcb` and `bcbc`; and,
+* **2 copies** of all remaining tiles: `cccc`, `bbbb`, `dacc`, `cdac`, `ccda`, `accd`, `dbba`, `adbb`, `badb`, `bbad`, `ddbc`, `cddb`, `bcdd`, `dbcd`, `adad`, `dada` and `dddd`.
+
+Individual images of each tile can be found in `src/gui/assets`.
+
+### Tile Placements
+
+A *tile placement* string is a six character string, the first four characters of which represent a [tile](#tiles).
+The final two characters are digits between 0 and 7 denoting the row and column of the tile (in that order).
+For example, the tile `cccc` in row 3, column 2 would be labelled `cccc32`. 
+
+A *placement sequence* string is a concatenation of up to 60 tile placement strings, representing all tiles that have been placed so far in a game.
+
+### Scoring
+
+
+Any metro lines that start at a player's station and end at a station score points. 
+A player scores 1 point *for each tile the metro line crosses.* If a metro line crosses a tile *more than once*, then the player
+scores 1 point for *every time that line crosses the tile.* If a line ends at one of the central stations,
+the points for that line are doubled. 
+
+For example: In the image below, the yellow player scores 19 points on station 11.
+(Remember tracks can finish at any station, this one just happens to loop back to itself).
+
+![Example track scoring](assets/scoring_example_1.png)
+
+
+## Legal and Ethical Issues
+
+First, as with any work you do, you must abide by the principles of
+[honesty and integrity](http://academichonesty.anu.edu.au). You are
+expected to demonstrate honesty and integrity in everything you do.
+
+In addition to those ground rules, you are to follow the rules one
+would normally be subject to in a commercial setting. In particular,
+you may make use of the works of others under two fundamental
+conditions: a) your use of their work must be clearly acknowledged,
+and b) your use of their work must be legal (for example, consistent
+with any copyright and licensing that applies to the given
+material). *Please understand that violation of these rules is a very
+serious offence.* However, as long as you abide by these rules, you
+are explicitly invited to conduct research and make use of a variety
+of sources. You are also given an explicit means with which to declare
+your use of other sources (via originality statements you must
+complete). It is important to realize that you will be assessed on the
+basis of your original contributions to the project. While you won't
+be penalized for correctly attributed use of others' ideas, the work
+of others will not be considered as part of your
+contribution. Therefore, these rules allow you to copy another
+student's work entirely if: a) they gave you permission to do so, and
+b) you acknowledged that you had done so. Notice, however, that if you
+were to do this you would have no original contribution and so would
+receive no marks for the assignment (but you would not have broken any
+rules either).
+
+## Evaluation Criteria
+
+It is essential that you refer to the
+[deliverables page](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/)
+to check that you understand each of the deadlines and what is
+required.  Your assignment will be marked via tests run through GitLab's
+continuous integration (CI) framework, so all submittable materials
+will need to be in GitLab and in the *correct* locations, as prescribed
+by the
+[deliverables page](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/).
+
+
+**The mark breakdown is described on the
+[deliverables](https://cs.anu.edu.au/courses/comp1110/assessments/deliverables/)
+page.**
+
+### Part One
+
+In the first part of the assignment you will:
+* Implement parts of the text interface to the game (Tasks #2 and #3).
+* Implement a simple viewer that allows you to visualize game states (Task #4).
+
+The criteria for the [completion of part one](https://gitlab.cecs.anu.edu.au/comp1110/comp1110/wikis/deliverables#d2c-assignment-2-stage-c-2-marks-group) are as follows:
+
+<a name="p"></a>
+**Pass**
+* Tasks #2 and #3
+
+<a name="cr"></a>
+**Credit**
+* Task #4 *(in addition to all tasks required for Pass)*
+
+<a name="d"></a>
+**Distinction**
+* Task #5 *(in addition to all tasks required for Credit)*
+
+### Part Two
+
+Create a fully working game, using JavaFX to implement a playable
+graphical version of the game in a 1024x768 window.
+
+Notice that aside from the window size, the details of exactly how the
+game looks etc. are **intentionally** left up to you.  The diagrams
+above are for illustration purposes only, although you are welcome to
+use all of the resources provided in this repo, including the bitmap
+images.
+
+The only **firm** requirements are that:
+
+* you use Java and JavaFX,
+* the game respects the specification given here,
+* the game be easy to play,
+* it runs in a 1024x768 window, and
+* that it is executable on a standard lab machine from a JAR file called `game.jar`,
+
+Your game must successfully run from `game.jar` from within another
+user's (i.e.  your tutor's) account on a standard lab machine.
+In other words, your game must not depend on features not self-contained
+within that JAR file and the Java 13 runtime.
+
+<a name="2p"></a>
+**Pass**
+* Correctly implements all of the <b>Part One</b> criteria.
+* Appropriate use of git (as demonstrated by the history of your repo).
+* Completion of Task #6 and #7
+* Executable on a standard lab computer from a runnable JAR file,
+  game.jar, which resides in the root level of your group repo.
+
+<a name="2c"></a>
+**Credit**
+* _All of the Pass-level criteria, plus the following..._
+* Task #8
+
+<a name="2d"></a>
+**Distinction**
+* _All of the Credit-level criteria, plus the following..._
+* Tasks #9 and #10
+
+<a name="2hd"></a>
+**High Distinction**
+* _All of the Distinction-level criteria, plus the following..._
+* Tasks #11 and #12
+
+
Only in comp1110-ass2/src/comp1110/ass2: Config.java
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: board_withoutEdges.png
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p10.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p11.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p12.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p1.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p2.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p3.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p4.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p5.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p6.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p7.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p8.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui/assets: p9.jpg
Only in comp1110-ass2/src/comp1110/ass2/gui: Game.fxml
Only in comp1110-ass2/src/comp1110/ass2/gui: Game.java
Only in comp1110-ass2/src/comp1110/ass2/gui: styleGame.css
Only in comp1110-ass2/src/comp1110/ass2/gui: Test.java
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java comp1110-ass2/src/comp1110/ass2/gui/Viewer.java
--- ../master/comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2020-04-27 18:58:35.729962734 +1000
+++ comp1110-ass2/src/comp1110/ass2/gui/Viewer.java	2020-05-11 07:49:42.759089966 +1000
@@ -1,77 +1,163 @@
-package comp1110.ass2.gui;
-
-import javafx.application.Application;
-import javafx.event.ActionEvent;
-import javafx.event.EventHandler;
-import javafx.scene.Group;
-import javafx.scene.Scene;
-import javafx.scene.control.Button;
-import javafx.scene.control.Label;
-import javafx.scene.control.TextField;
-import javafx.scene.layout.HBox;
-import javafx.stage.Stage;
-
-/**
- * A very simple viewer for piece placements in the Metro game.
- * <p>
- * NOTE: This class is separate from your main game class.  This
- * class does not play a game, it just illustrates various piece
- * placements.
- */
-public class Viewer extends Application {
-    /* board layout */
-    private static final int SQUARE_SIZE = 70;
-    private static final int VIEWER_WIDTH = 1024;
-    private static final int VIEWER_HEIGHT = 768;
-
-    private static final String URI_BASE = "assets/";
-
-    private final Group root = new Group();
-    private final Group controls = new Group();
-    private TextField textField;
-
-    /**
-     * Draw a placement in the window, removing any previously drawn one
-     *
-     * @param placement A valid placement string
-     */
-    void makePlacement(String placement) {
-        // FIXME Task 4: implement the simple placement viewer
-    }
-
-    /**
-     * Create a basic text field for input and a refresh button.
-     */
-    private void makeControls() {
-        Label label1 = new Label("Placement:");
-        textField = new TextField();
-        textField.setPrefWidth(300);
-        Button button = new Button("Refresh");
-        button.setOnAction(new EventHandler<ActionEvent>() {
-            @Override
-            public void handle(ActionEvent e) {
-                makePlacement(textField.getText());
-                textField.clear();
-            }
-        });
-        HBox hb = new HBox();
-        hb.getChildren().addAll(label1, textField, button);
-        hb.setSpacing(10);
-        hb.setLayoutX(130);
-        hb.setLayoutY(VIEWER_HEIGHT - 50);
-        controls.getChildren().add(hb);
-    }
-
-    @Override
-    public void start(Stage primaryStage) throws Exception {
-        primaryStage.setTitle("FocusGame Viewer");
-        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
-
-        root.getChildren().add(controls);
-
-        makeControls();
-
-        primaryStage.setScene(scene);
-        primaryStage.show();
-    }
-}
+package comp1110.ass2.gui;
+
+import javafx.application.Application;
+import javafx.event.ActionEvent;
+import javafx.event.EventHandler;
+import javafx.scene.Group;
+import javafx.scene.Scene;
+import javafx.scene.control.Button;
+import javafx.scene.control.Label;
+import javafx.scene.control.TextField;
+import javafx.scene.image.Image;
+import javafx.scene.image.ImageView;
+import javafx.scene.layout.*;
+import javafx.stage.Stage;
+
+/**
+ * A very simple viewer for piece placements in the Metro game.
+ * <p>
+ * NOTE: This class is separate from your main game class.  This
+ * class does not play a game, it just illustrates various piece
+ * placements.
+ */
+public class Viewer extends Application {
+    /* board layout */
+    private static final int SQUARE_SIZE = 70;
+    private static final int VIEWER_WIDTH = 1024;
+    private static final int VIEWER_HEIGHT = 768;
+
+    private static final String URI_BASE = "assets/";
+
+    private final Group root = new Group();
+    private final Group controls = new Group();
+    private TextField textField;
+
+    public static void main(String[] args) {
+        launch(args);
+    }
+
+    /**
+     * Draw a placement in the window, removing any previously drawn one
+     *
+     * @param placement A valid placement string
+     */
+    void makePlacement(String placement) {
+        // Task 4: implement the simple placement viewer
+        //// author of this method: Yiwei (u7020050)
+        //board
+        GridPane board = new GridPane();
+
+        for (int i = 1; i <= 8; i++) {
+            ImageView station = new ImageView();
+            String stationLoc = URI_BASE + "station" + i + ".jpg";
+            station.setFitWidth(64);
+            station.setFitHeight(64);
+            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
+            board.add(station, 9 - i, 0);
+        }
+
+        for (int i = 9; i <= 16; i++) {
+            ImageView station = new ImageView();
+            String stationLoc = URI_BASE + "station" + i + ".jpg";
+            station.setFitWidth(64);
+            station.setFitHeight(64);
+            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
+            board.add(station, 0, i - 8);
+        }
+
+        for (int i = 17; i <= 24; i++) {
+            ImageView station = new ImageView();
+            String stationLoc = URI_BASE + "station" + i + ".jpg";
+            station.setFitWidth(64);
+            station.setFitHeight(64);
+            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
+            board.add(station, i - 16, 9);
+        }
+
+        for (int i = 25; i <= 32; i++) {
+            ImageView station = new ImageView();
+            String stationLoc = URI_BASE + "station" + i + ".jpg";
+            station.setFitWidth(64);
+            station.setFitHeight(64);
+            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
+            board.add(station, 9, 33 - i);
+        }
+
+        //corner
+        ImageView corner = new ImageView();
+        corner.setFitHeight(64);
+        corner.setFitWidth(64);
+        corner.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
+        board.add(corner, 0, 0);
+
+        ImageView corner1 = new ImageView();
+        corner1.setFitHeight(64);
+        corner1.setFitWidth(64);
+        corner1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
+        board.add(corner1, 0, 9);
+
+        ImageView corner2 = new ImageView();
+        corner2.setFitHeight(64);
+        corner2.setFitWidth(64);
+        corner2.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
+        board.add(corner2, 9, 0);
+
+        ImageView corner3 = new ImageView();
+        corner3.setFitHeight(64);
+        corner3.setFitWidth(64);
+        corner3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
+        board.add(corner3, 9, 9);
+
+        //tile placement
+        for(int idx = 0;idx<placement.length();idx+=6){
+            String tileType = placement.substring(idx, idx+4);
+            int row = Integer.parseInt(placement.substring(idx+4, idx+5));
+            int column = Integer.parseInt(placement.substring(idx+5, idx+6));
+
+            String tileLoc = URI_BASE + tileType + ".jpg";
+
+            ImageView tile = new ImageView();
+            tile.setFitWidth(64);
+            tile.setFitHeight(64);
+            tile.setImage(new Image(this.getClass().getResource(tileLoc).toString()));
+
+            board.add(tile, column + 1, row+1);
+        }
+
+        root.getChildren().add(board);
+    }
+
+    /**
+     * Create a basic text field for input and a refresh button.
+     */
+    private void makeControls() {
+        Label label1 = new Label("Placement:");
+        textField = new TextField("Board appears after correct placement input"); //Yiwei added String Apr 19th
+        textField.setPrefWidth(300);
+
+        Button button = new Button("Refresh");
+        button.setOnAction(new EventHandler<ActionEvent>() {
+            @Override
+            public void handle(ActionEvent e) {
+                makePlacement(textField.getText());
+                textField.clear();
+            }
+        });
+        HBox hb = new HBox();
+        hb.getChildren().addAll(label1, textField, button);
+        hb.setSpacing(10);
+        hb.setLayoutX(130);
+        hb.setLayoutY(VIEWER_HEIGHT - 50);
+        controls.getChildren().add(hb);
+    }
+
+    @Override
+    public void start(Stage primaryStage) throws Exception {
+        primaryStage.setTitle("FocusGame Viewer");
+        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
+        root.getChildren().add(controls);
+        makeControls();
+        primaryStage.setScene(scene);
+        primaryStage.show();
+    }
+}
diff -ru -x .git ../master/comp1110-ass2/src/comp1110/ass2/Metro.java comp1110-ass2/src/comp1110/ass2/Metro.java
--- ../master/comp1110-ass2/src/comp1110/ass2/Metro.java	2020-05-29 13:44:00.520497777 +1000
+++ comp1110-ass2/src/comp1110/ass2/Metro.java	2020-05-11 07:49:42.759089966 +1000
@@ -1,103 +1,177 @@
-package comp1110.ass2;
-
-public class Metro {
-    /**
-     * Task 2
-     * Determine whether a piece placement is well-formed. For a piece
-     * placement to be well-formed, it must:
-     * - contain exactly six characters;
-     * - have as its first, second, third and fourth characters letters between
-     * 'a' and 'd' inclusive (tracks); and
-     * - have as its fifth and sixth characters digits between 0 and 7 inclusive
-     * (column and row respectively).
-     *
-     * @param piecePlacement A String representing the piece to be placed
-     * @return True if this string is well-formed
-     */
-    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
-        // FIXME Task 2: determine whether a piece placement is well-formed
-        return false;
-    }
-
-    /**
-     * Task 3
-     * Determine whether a placement sequence string is well-formed.
-     * For a placement sequence to be well-formed, it must satisfy the
-     * following criteria:
-     * - It must be composed of well-formed tile placements.
-     * - For any piece x, there can exist no more instances of x on the board
-     * than instances of x in the deck.
-     *
-     * @param placement A String representing the placement of all tiles on the
-     *                  board
-     * @return true if this placement sequence is well-formed
-     */
-    public static boolean isPlacementSequenceWellFormed(String placement) {
-        // FIXME Task 3: determine whether a placement sequence is well-formed
-        return false;
-    }
-
-    /**
-     * Task 5
-     * Draw a random tile from the deck.
-     *
-     * @param placementSequence a String representing the sequence of tiles
-     *                          that have already been played
-     * @param totalHands        a String representing all tiles (if any) in
-     *                          all players' hands
-     * @return a random tile from the deck
-     */
-    public static String drawFromDeck(String placementSequence, String totalHands) {
-        // FIXME Task 5: draw a random tile from the deck
-        return "";
-    }
-
-    /**
-     * Task 6
-     * Determine if a given placement sequence follows the rules of the game.
-     * These rules are:
-     * - No tile can overlap another tile, or any of the central stations.
-     * - A tile cannot be placed next to one of the central squares unless it
-     * continues or completes an existing track.
-     * - If a tile is on an edge of the board, it cannot contain a track that
-     * results in a station looping back to itself, UNLESS that tile could not
-     * have been placed elsewhere.
-     * - If a tile is on a corner of the board, it cannot contain a track that
-     * links the two stations adjacent to that corner, UNLESS that tile could
-     * not have been placed elsewhere.
-     *
-     * @param placementSequence A sequence of placements on the board.
-     * @return Whether this placement string is valid.
-     */
-    public static boolean isPlacementSequenceValid(String placementSequence) {
-        // FIXME Task 6: determine whether a placement sequence is valid
-        return false;
-    }
-
-    /**
-     * Task 7
-     * Determine the current score for the game.
-     *
-     * @param placementSequence a String representing the sequence of piece placements made so far in the game
-     * @param numberOfPlayers   The number of players in the game
-     * @return an array containing the scores for all players
-     */
-    public static int[] getScore(String placementSequence, int numberOfPlayers) {
-        // FIXME Task 7: determine the current score for the game
-        return new int[0];
-    }
-
-    /**
-     * Task 9
-     * Given a placement sequence string, generate a valid next move.
-     *
-     * @param placementSequence a String representing the sequence of piece placements made so far in the game
-     * @param piece             a four-character String representing the tile to be placed
-     * @param numberOfPlayers   The number of players in the game
-     * @return A valid placement of the given tile
-     */
-    public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
-        // FIXME Task 9: generate a valid move
-        return "";
-    }
-}
+package comp1110.ass2;
+
+import java.util.ArrayList;
+import java.util.Arrays;
+import java.util.Random;
+
+public class Metro {
+    /**
+     * Task 2
+     * Determine whether a piece placement is well-formed. For a piece
+     * placement to be well-formed, it must:
+     * - contain exactly six characters;
+     * - have as its first, second, third and fourth characters letters between
+     * 'a' and 'd' inclusive (tracks); and
+     * - have as its fifth and sixth characters digits between 0 and 7 inclusive
+     * (column and row respectively).
+     *
+     * @param piecePlacement A String representing the piece to be placed
+     * @return True if this string is well-formed
+     */
+    // author of this method: Luna
+    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
+        if (piecePlacement.length() == 6) {
+            if (piecePlacement.charAt(0) <= 'd' && piecePlacement.charAt(0) >= 'a'
+                    && piecePlacement.charAt(1) <= 'd' && piecePlacement.charAt(1) >= 'a'
+                    && piecePlacement.charAt(2) <= 'd' && piecePlacement.charAt(2) >= 'a'
+                    && piecePlacement.charAt(3) <= 'd' && piecePlacement.charAt(3) >= 'a') {
+                if (Character.getNumericValue(piecePlacement.charAt(4)) <= 7 && Character.getNumericValue(piecePlacement.charAt(4)) >= 0
+                        && Character.getNumericValue(piecePlacement.charAt(5)) <= 7 && Character.getNumericValue(piecePlacement.charAt(5)) >= 0) {
+                    return true;
+                }
+            }
+        }
+        return false;
+    }
+
+    /**
+     * Task 3
+     * Determine whether a placement sequence string is well-formed.
+     * For a placement sequence to be well-formed, it must satisfy the
+     * following criteria:
+     * - It must be composed of well-formed tile placements.
+     * - For any piece x, there can exist no more instances of x on the board
+     * than instances of x in the deck.
+     *
+     * @param placement A String representing the placement of all tiles on the
+     *                  board
+     * @return true if this placement sequence is well-formed
+     */
+    // author of this method: Birdy(u6864755)
+    public static boolean isPlacementSequenceWellFormed(String placement) {
+        if (placement.length() == 0)
+            return true;
+        if (placement.length() < 360 && (placement.length() % 6) == 0) {
+
+            foo:
+            for (int i = 0; i < placement.length(); i += 6) {
+                String pieceplacement = (placement.substring(i, i + 6));
+                if (isPiecePlacementWellFormed(pieceplacement) == true) {
+                    if (i == placement.length() - 6) {
+                        return true;
+                    }
+
+                    continue foo;
+                }
+            }
+            return false;
+        }
+        return false;
+    }
+
+    /**
+     * Task 5
+     * Draw a random tile from the deck.
+     *
+     * @param placementSequence a String representing the sequence of tiles
+     *                          that have already been played
+     * @param totalHands        a String representing all tiles (if any) in
+     *                          all players' hands
+     * @return a random tile from the deck
+     */
+    public static String drawFromDeck(String placementSequence, String totalHands) {
+        // Task 5: draw a random tile from the deck
+        //// author of this method: Yiwei (u7020050)
+        ArrayList<String> tileList = new ArrayList<String>(
+                Arrays.asList("aacb", "aacb", "aacb", "aacb",
+                        "cbaa", "cbaa", "cbaa", "cbaa",
+                        "acba", "acba", "acba", "acba",
+                        "baac", "baac", "baac", "baac",
+                        "aaaa", "aaaa", "aaaa", "aaaa",
+                        "cbcb", "cbcb", "cbcb",
+                        "bcbc", "bcbc", "bcbc",
+                        "cccc", "cccc",
+                        "bbbb", "bbbb",
+                        "dacc", "dacc",
+                        "cdac", "cdac",
+                        "ccda", "ccda",
+                        "accd", "accd",
+                        "dbba", "dbba",
+                        "adbb", "adbb",
+                        "badb", "badb",
+                        "bbad", "bbad",
+                        "ddbc", "ddbc",
+                        "cddb", "cddb",
+                        "bcdd", "bcdd",
+                        "dbcd", "dbcd",
+                        "adad", "adad",
+                        "dada", "dada",
+                        "dddd", "dddd"));
+        for (int i = 0; i < placementSequence.length(); i += 6) {
+            String currentTile = placementSequence.substring(i, i + 4);
+            tileList.remove(currentTile);
+        }
+
+        for (int j = 0; j < totalHands.length(); j += 4) {
+            String currentHand = totalHands.substring(j, j + 4);
+            tileList.remove(currentHand);
+        }
+
+        String randomTile = tileList.get(new Random().nextInt(tileList.size()));
+
+        return randomTile;
+    }
+
+    /**
+     * Task 6
+     * Determine if a given placement sequence follows the rules of the game.
+     * These rules are:
+     * - No tile can overlap another tile, or any of the central stations.
+     * - A tile cannot be placed next to one of the central squares unless it
+     * continues or completes an existing track.
+     * - If a tile is on an edge of the board, it cannot contain a track that
+     * results in a station looping back to itself, UNLESS that tile could not
+     * have been placed elsewhere.
+     * - If a tile is on a corner of the board, it cannot contain a track that
+     * links the two stations adjacent to that corner, UNLESS that tile could
+     * not have been placed elsewhere.
+     *
+     * @param placementSequence A sequence of placements on the board.
+     * @return Whether this placement string is valid.
+     */
+    public static boolean isPlacementSequenceValid(String placementSequence) {
+        if (placementSequence.length() == 0)
+            return true;
+
+
+        return false;
+    }
+
+    /**
+     * Task 7
+     * Determine the current score for the game.
+     *
+     * @param placementSequence a String representing the sequence of piece placements made so far in the game
+     * @param numberOfPlayers   The number of players in the game
+     * @return an array containing the scores for all players
+     */
+    // author of this method: Luna
+    public static int[] getScore(String placementSequence, int numberOfPlayers) {
+
+        return new RoadMap(placementSequence, numberOfPlayers).getScore();
+    }
+
+    /**
+     * Task 9
+     * Given a placement sequence string, generate a valid next move.
+     *
+     * @param placementSequence a String representing the sequence of piece placements made so far in the game
+     * @param piece             a four-character String representing the tile to be placed
+     * @param numberOfPlayers   The number of players in the game
+     * @return A valid placement of the given tile
+     */
+    public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
+        // FIXME Task 9: generate a valid move
+        return "";
+    }
+}
Only in comp1110-ass2/src/comp1110/ass2: RoadMap.java
Only in comp1110-ass2/src/comp1110/ass2: SkeletonOverview.java
Only in comp1110-ass2/src/comp1110/ass2: Square.java
Only in comp1110-ass2/src/comp1110/ass2: Tile.java
Only in comp1110-ass2/src/comp1110/ass2: TileRoad.java
Only in comp1110-ass2/src/comp1110/ass2: TileType.java
Only in comp1110-ass2/src/comp1110/ass2: TrainPosition.java
Only in comp1110-ass2/src/comp1110/ass2: TrainState.java
Only in comp1110-ass2/tests/comp1110/ass2: D2Eu6648214.java
Only in comp1110-ass2/tests/comp1110/ass2: D2Eu6864755.java
Only in comp1110-ass2/tests/comp1110/ass2: D2Eu7020050.java
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/GenerateMoveTest.java comp1110-ass2/tests/comp1110/ass2/GenerateMoveTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/GenerateMoveTest.java	2020-05-29 13:44:00.520497777 +1000
+++ comp1110-ass2/tests/comp1110/ass2/GenerateMoveTest.java	2020-05-03 11:32:33.127473451 +1000
@@ -44,10 +44,9 @@
             String moveSet = Utilities.MISCELLANEOUS_MOVES[i];
             String boardString = moveSet.substring(0, moveSet.length() - 4);
             String piece = moveSet.substring(moveSet.length() - 4);
-            int numPlayers = i + 2;
-            String move = Metro.generateMove(boardString, piece, numPlayers);
+            String move = Metro.generateMove(boardString, piece, i + 2);
 
-            assertTrue("Metro.generateMove(\"" + boardString + "\", \"" + piece + "\", " + numPlayers + ") returned invalid move \"" + move + "\"",
+            assertTrue("Invalid move \"" + move + "\" for board string " + boardString,
                     Utilities.POSSIBLE_MOVES.get(i).contains(move));
         }
     }
@@ -63,8 +62,8 @@
             String move = Metro.generateMove(nearCompleteBoard, piece, numPlayers);
 
             assertNotNull("Metro.generateMove(\"" + nearCompleteBoard + "\", \"" + piece + "\", " + numPlayers + ") returned null", move);
-            assertFalse("Metro.generateMove(\"" + nearCompleteBoard + "\", \"" + piece + "\", " + numPlayers + ") returned empty string", move.isEmpty());
-            assertEquals("Metro.generateMove(\"" + nearCompleteBoard + "\", \"" + piece + "\", " + numPlayers + ") expected placement (" + expected.charAt(0) + ", " + expected.charAt(1) +
+            assertFalse("Metro.generateMove(\"" + nearCompleteBoard + "\", " + piece + ", " + numPlayers + ") returned empty string", move.isEmpty());
+            assertEquals("Expected placement in (" + expected.charAt(0) + ", " + expected.charAt(1) +
                     "), got (" + move.charAt(4) + ", " + move.charAt(5) + ")", piece + expected, move);
         }
     }
diff -ru -x .git ../master/comp1110-ass2/tests/comp1110/ass2/IsPiecePlacementWellFormedTest.java comp1110-ass2/tests/comp1110/ass2/IsPiecePlacementWellFormedTest.java
--- ../master/comp1110-ass2/tests/comp1110/ass2/IsPiecePlacementWellFormedTest.java	2020-04-27 18:58:35.733962707 +1000
+++ comp1110-ass2/tests/comp1110/ass2/IsPiecePlacementWellFormedTest.java	2020-05-04 21:34:59.695348642 +1000
@@ -18,7 +18,7 @@
                 ", but got " + out, out == expected);
     }
 
-
+;
     @Test
     public void testWellFormed() {
         testTrivial();
```
