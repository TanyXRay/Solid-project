# Работа с применением основных принципов Solid, Dry, Magic counts.

##### В данном проекте исправлен изначальный код, в котором были нарушены вышеуказанные в названии принципы:

- *Нарушение принципа магических чисел: для инициализации Purchase[] purchases было использовано число напрямую (new
  Purchase[4]). Исправление: инициализация массива происходит в момент создания экземпляра класса Basket, т.е. в
  аргуметы конструктора Basket было передано пользователем число для последующей инициализации массива;*

- *Нарушение принципа единой ответственности: вся логика работы с покупкой была завязана на классе Purchase, для
  декомпозирования данных был создан класс Basket, в котором в методах addPurchase() и sumAllProducts() создавался экземпляр объекта
  Purchase и обращение к полям этого класса было через setter's/getter's;*

- *Нарушение принципа инверсии зависимостей, принципа открытости/закрытости: изначально все действия по покупке были определены в классе Purchase, но
  что если будет необходимо внести расширение, например, по удалению покупки? В таком случае нужно будет напрямую
  обращаться к классу и модифицировать его, дополняя новыми функциями, что не совсем лучшее решение. Для уменьшение
  связанности клиентского класса с реализацией был создан интерфейс BasketInt, который реализует класс Basket, таким
  образом, клиентский класс получает реализацию зависимости для выполнения необходимого действия и знает минимум для
  выполнения своих действий, что является примером слабого связывания;*

- *В main() при создании мапы списка продуктов было указано создание в виде: HashMap<String, Integer> products = new
  HashMap<>(), лучше все-таки не забывать про полиморфизм и указать запись как: Map<String, Integer>
  products = new HashMap<>().*
