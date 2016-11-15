# regexp-sample
A simple implementation of a Regex Engine

It supports only `.` (any character) + symbol and the `*` repeater.

Main inspiration is from https://swtch.com/~rsc/regexp/regexp1.html

The `Pattern` class is used for matching:

    Pattern p = new Pattern(pattern);
    boolean matches = p.match(haystack);

Or one can use the convenince static method:

    boolean matches = Patterm.match(haystack, pattern);

Note that the `*` is currently non-greedy.

For examples see `RegexpTest`:

     string: aaaabc, pattern: a, matches: false
     string: aaaabc, pattern: a., matches: false
     string: aaaabc, pattern: ., matches: false
     string: aaaabc, pattern: .*, matches: true
     string: aaaabc, pattern: a.*, matches: true
     string: aaaabc, pattern: a*bc, matches: true
     string: baaaabc, pattern: a*bc, matches: false
     string: baaaabc, pattern: .c, matches: false
     string: qc, pattern: .c, matches: true
     string: qqcqcqqcccic, pattern: .*, matches: true
     string: qqcqcqqcccic, pattern: .*x, matches: false

