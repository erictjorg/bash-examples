bash-examples
=============

Bash examples using classroom concepts but without direct lab answers

---

A few header lines to explain why I sometimes use different ones:

```bash
#!/bin/bash             # Standard location in most Linux distros
#!/usr/bin/bash         # Cygwin's edition isn't quite the same
#!/usr/local/bin/bash   # Nor are OpenBSD/FreeBSD systems
#!/usr/pkg/bin/bash     # Nor are NetBSD systems
#!/usr/bin/env bash     # One #! to rule them all: basically a $(which bash)
```
---

Examples include:

+ /colorize/ (with /colorize.conf/): Use a configuration file to process the screen printing of a text file with a repeating color pattern. 
+ /git-multi/: Use command line options to pick activity on all local git repositories. Only 'fetch' and 'status' (or both).
+ /git-menu/ (with /misctools.sh/): Use a looped menu to do the same thing as /git-multi/ with validated input and an imported library of functions.

