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

+ __colorize__ (with __colorize.conf__) Use a configuration file to process the screen printing of a text file with a repeating color pattern. 
+ __git-multi__: Use command line options to pick activity on all local git repositories. Only 'fetch' and 'status' (or both).
+ __git-menu__ (with __misctools.sh__): Use a looped menu to do the same thing as __git-multi__ with validated input and an imported library of functions.

