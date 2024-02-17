import datetime
from typing import List


def maxProfit(prices: List[int]) -> int:
    min_price = prices[0]
    max_profit = 0

    for price in prices[1:]:
        max_profit = max(max_profit, price - min_price)
        min_price = min(min_price, price)

    return max_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    before = datetime.datetime.now()
    result = maxProfit(prices)
    after = datetime.datetime.now()
    print(result, after - before)

    prices = [7, 6, 4, 3, 1]
    before = datetime.datetime.now()
    result = maxProfit(prices)
    after = datetime.datetime.now()
    print(result, after - before)

    prices = [i for i in range(10_000)]
    before = datetime.datetime.now()
    result = maxProfit(prices)
    after = datetime.datetime.now()
    print(result, after - before)
