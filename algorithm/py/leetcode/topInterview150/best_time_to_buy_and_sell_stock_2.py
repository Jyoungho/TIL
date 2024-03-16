from typing import List


def maxProfit(prices: List[int]) -> int:
    acc_profit = 0
    buy_price = prices[0]

    for price in prices:
        if price > buy_price:
            acc_profit += - (buy_price - price)
            buy_price = price
        elif price < buy_price:
            buy_price = price

    return acc_profit


if __name__ == '__main__':
    prices = [7, 1, 5, 3, 6, 4]
    result = maxProfit(prices)
    print('---result---')
    print(result)

    prices = [1, 2, 3, 4, 5]
    result = maxProfit(prices)
    print('---result---')
    print(result)

    prices = [7, 6, 4, 3, 1]
    result = maxProfit(prices)
    print('---result---')
    print(result)
