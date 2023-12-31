## 本项目实现的最终作用是基于JSP在线文具销售平台商城
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 修改密码
 - 分类管理
 - 文具管理
 - 用户管理
 - 管理员登录
 - 订单管理
### 第2个角色为用户角色，实现了如下功能：
 - 提交订单
 - 查看商品详情
 - 查看我的订单
 - 查看购物车
 - 查看首页
 - 用户登录
## 数据库设计如下：
# 数据库设计文档

**数据库名：** wenjushop

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [admin](#admin) | 管理员表 |
| [admin_copy](#admin_copy) |  |
| [category](#category) | 分类表 |
| [orders](#orders) | 订单信息表 |
| [user](#user) | 用户表 |
| [wenju](#wenju) |  |

**表名：** <a id="admin">admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="admin_copy">admin_copy</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | password |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="category">category</a>

**说明：** 分类表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 分类名称，如：小说  |
|  3   | grade |   int   | 10 |   0    |    N     |  N   |   1    | 分类等级，若是1，则为最大分类  |
|  4   | parent |   int   | 10 |   0    |    N     |  N   |   0    | 上级分类，若为0则表示是根目录  |

**表名：** <a id="orders">orders</a>

**说明：** 订单信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 名字  |
|  3   | price |   int   | 10 |   0    |    N     |  N   |       | 价格  |
|  4   | quantity |   int   | 10 |   0    |    N     |  N   |   1    |   |
|  5   | total |   int   | 10 |   0    |    N     |  N   |       | 总计  |
|  6   | user |   varchar   | 255 |   0    |    N     |  N   |   ''    |   |
|  7   | wenjuid |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | shou |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | ADDRESS |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 地址  |
|  10   | info |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | phone |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 手机号码  |
|  12   | status |   int   | 10 |   0    |    Y     |  N   |   NULL    | 状态  |

**表名：** <a id="user">user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | username |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  3   | nickname |   varchar   | 255 |   0    |    N     |  N   |       | 昵称  |
|  4   | password |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |

**表名：** <a id="wenju">wenju</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | name |   varchar   | 255 |   0    |    N     |  N   |       | 名字  |
|  3   | author |   varchar   | 255 |   0    |    N     |  N   |       | 作者  |
|  4   | price |   int   | 10 |   0    |    N     |  N   |       | 价格  |
|  5   | introduction |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 简单的介绍书籍  |
|  6   | stock |   int   | 10 |   0    |    N     |  N   |       | 书本库存  |
|  7   | category |   varchar   | 255 |   0    |    N     |  N   |       |   |
|  8   | cover |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | time |   date   | 10 |   0    |    Y     |  N   |   NULL    | 时间日期  |

**运行不出来可以微信 javape 我的公众号：源码码头**
