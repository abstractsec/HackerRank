## [Mangos](https://www.hackerrank.com/challenges/mango/problem)

It's the time of the year when fresh mangos are available. Bob has a very good day at his school today and decides to treat some of his friends with mangos. There are N people in his friend circle, and he has M mangos. Initial appetite level of the friends is represented by an array a = {a[1], a[2], ..., a[N]}, where a[1] represents appetite level of first friend, a[2] represents appetite level of second friend, and so on. Apart from this, each friend has a happiness factor which is represented by an array h = {h[1], h[2], ..., h[N]}. If ith friend is invited to the party, and he finds that there are p other friends, then he will eat a[i] + p*h[i] mangos.

Thus, if k friends, indexed b = {b1, b2...bk}, are invited to party, then total number of mangos consumed will be (a[b1]+(k-1)*h[b1]) + (a[b2]+(k-1)*h[b2]) + ... + (a[bk]+(k-1)*h[bk]).

For example, if there are N = 5 friends whose initial appetite is represented by a = {2, 5, 3, 2, 4} and happiness factor is represented by h = {30, 40, 10, 20, 30}. Suppose Bob invites k = 3 friends, indexed {2, 4, 5}, then total number of mangos eaten will be
```
= (a[2]+(3-1)*h[2]) + (a[4]+(3-1)*h[4]) + (a[5]+(3-1)*h[5])
= (5+2*40) + (2+2*20) + (4+2*30)
= 85 + 42 + 64
= 191
```

Bob is wondering what is the maximum number of friends he can invite to his treat, so that, their hunger can be completely satisfied.

Note: It is not necessary that all mangos have to be consumed.

### Input
The first line contains two space separated integers, N M, where N is the number of friends, and M is the number of mangos Bob has. Then in next line follows N space separated integers, a[1], a[2],..., a[N], which represent the initial appetite of friends. In next line there are again N space separated integers, h[1], h[2],..., h[N], representing the happiness factor for friends.

### Output 
Print the maximum number of friends which Bob can invite to his treat.

### Constraints 
1 ≤ N ≤ 5 * 10^4 
1 ≤ M ≤ 2.5 * 10^15 
1 ≤ a[i], h[i] ≤ 10^6 , where i ∈ [1, N]

#### Sample Input #00
```
5 200
2 5 3 2 4
30 40 10 20 30
```
#### Sample Output #00
```
3
```
#### Sample Input #01
```
2 100
3 4
1 2
```
#### Sample Output #00
```
2
```
#### Explanation 
Test Case #00: This case is explaned in the statement.

Test Case #01: We can call both people. They will consume  mangos. Hence, only 10 mangos are consumed.
