from typing import ItemsView


# item 1

import sys 
print(sys.version_info) 
print(sys.version)


# Item 2: Follow the PEP 8 Style Guide

empty_list = []
empty_str =''
non_empty_list = [1]
non_empty_str ='hi'

mylist = [1,2,3,4]

if mylist:
    print(mylist)

if not empty_list:
    print('empty_list',empty_list)

if not empty_str:
    print('empty_str',empty_str)


if not non_empty_list:
    print('empty_list',non_empty_list)
else:
    print('non_empty_list',non_empty_list)

if not non_empty_str:
    print('empty_str',non_empty_str)
else:
    print('non_empty_str',non_empty_str)

print("long ddddddddddddddddddd\
eeeeeeeeeeeeeeeeeee")


flavor_list = ['a','b','c']
for i, flavor in enumerate(flavor_list):
    print(f"{i},{flavor}")

counts = [1,2,3]
for count , flavor in zip(counts,flavor_list):
    print(count,flavor)


# item 13

car_ages = [0, 9, 4, 8, 7, 20, 19, 1, 6, 15] 
car_ages_descending = sorted(car_ages, reverse=True) 

oldest, second_oldest ,*others = car_ages_descending
print(oldest,second_oldest,others)


# item 75

print(counts,flavor)
print(repr(counts),repr(flavor))