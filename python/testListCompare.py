import datetime
import functools
import time


def cmp(x1, x2):
    if "score" in x1 and "score" in x2:
        if x1["score"] > x2["score"]:
            return 1
        else:
            return -1
    else:
        return -1


if __name__ == "__main__":
    l = [
        {"score": "2023-10-10 10:00:00", "name": "d"},
        {"score": "2023-10-09 11:00:00", "name": "a"},
        {"score": "2023-10-10 12:00:00", "name": "b"},
        {"name": "zz"},
    ]
    l.sort(key=functools.cmp_to_key(cmp), reverse=True)
    print(l)

    l2 = sorted(l, key=functools.cmp_to_key(cmp), reverse=True)
    print(l2)
    size = len(l2)
    print(l2[1 - size:])

    print(datetime.datetime.now())
