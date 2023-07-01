
N = int(input())

mod = 1_000_000
a1 = 0
a2 = 1
result = 0;

for i in range(N - 1):
    result = (a1 + a2) % mod
    a1 = a2
    a2 = result
    
print(result)

    