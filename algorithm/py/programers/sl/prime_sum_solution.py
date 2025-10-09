def solution(N, M):
    primes = get_primes(N)

    if not primes:
        return 0

    n = len(primes)
    count = 0
    start = 0
    current_sum = 0

    for end in range(n):
        current_sum += primes[end]

        while current_sum > M and start <= end:
            current_sum -= primes[start]
            start += 1

        if current_sum == M:
            count += 1

    return count

def get_primes(n):
        if n < 2:
            return []

        is_prime = [True] * (n + 1)
        is_prime[0] = is_prime[1] = False

        for i in range(2, int(n**0.5) + 1):
            if is_prime[i]:
                for j in range(i*i, n + 1, i):
                    is_prime[j] = False

        return [i for i in range(2, n + 1) if is_prime[i]]

# sieve_of_eratosthenes