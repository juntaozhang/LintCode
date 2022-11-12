import math

import numpy as np
import pandas as pd

print(1 / math.e)
print(0.9 ** 10)
print(0.98 ** 50)


def draw_function(fn):
    import matplotlib.pyplot as plt
    import numpy as np
    x = np.linspace(-20, 20, 100)
    y = fn(x)
    # setting the axes at the centre
    fig = plt.figure()
    ax = fig.add_subplot(1, 1, 1)
    ax.spines['left'].set_position('center')
    ax.spines['bottom'].set_position('zero')
    ax.spines['right'].set_color('none')
    ax.spines['top'].set_color('none')
    ax.xaxis.set_ticks_position('bottom')
    ax.yaxis.set_ticks_position('left')

    # plot the function
    plt.plot(x, y, 'r')

    # show the plot
    plt.show()


# draw_function(lambda x: 0.9 ** x)
print(0.35 * 0.1 * 30)
df = pd.DataFrame({'B': [0, 1, 2, np.nan, 4]})

times = ['2020-01-01', '2020-01-03', '2020-01-10', '2020-01-15', '2020-01-17']
print(df.ewm(halflife='4 days', times=pd.DatetimeIndex(times)).mean())
