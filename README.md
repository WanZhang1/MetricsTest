# 1.MetricsTest工程介绍
该工程包含了几个简单样例代码，分别测试了Metrics的几种度量类型。

# 2.Metrics文档地址
官网文档：http://metrics.dropwizard.io/3.1.0/

github地址：https://github.com/dropwizard/metrics

# 3.Metrics简介
Metrics提供5种基本的度量类型：Gauges, Counters, Histograms, Meters和 Timers
 
## Gauge
Gauge是最简单的度量类型，只有一个简单的返回值，他用来记录一些对象或者事物的瞬时值。
比如，我们类型为Gauge的计数器来记录某个服务目前开通的城市个数

## Counters
Counter是一个简单64位的计数器，他可以增加和减少。
比如我们可以定义两个Counter类型的计数器，用来统计所有服务请求数目，和目前正在处理的请求总数。

## Meters
Meter是一种只能自增的计数器，通常用来度量一系列事件发生的比率。他提供了平均速率，以及指数平滑平均速率，以及采样后的1分钟，5分钟，15分钟速率。
比如需要统计请求的速率，比如统计平均每分钟内有多少次请求进来。只需要定义一个metric，在处理请求的地方，调用Mark方法即可。
再比如，要测量服务出错的概率，比如每小时出错多少次。可以定义一个metric，处理请求的时候，如果出现异常了，调用一下errorMeter的Mark方法即可。

## Histograms
Histrogram是用来度量流数据中Value的分布情况，Histrogram可以计算最大/小值、平均值，方差，分位数（如中位数，或者95th分位数），如75%,90%,98%,99%的数据在哪个范围内。
比如，我们想度量，所有传进来服务的请求参数的长度分布。那么，可以定义一个histogram，然后在请求的地方，调用其Update方法来更新值。

## Timer
Timer是Histogram跟Meter的一个组合，比如要统计当前请求的速率和处理时间。
定义一个Timer，在使用的时候，调用timer的NewContext即可。

# Health Checks
Metrics提供了一个独立的模块：Health Checks，用于对Application、其子模块或者关联模块的运行是否正常做检测。
该模块是独立metrics-core模块的，使用时则导入metrics-healthchecks包。

 
