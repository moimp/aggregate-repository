# Aggregate Repository

## Core Concept

> 이 repository 는 json 을 이용하여 aggregate 를 영속화 하는 과정의 복잡성을 줄여주고 aggregate 의 schema version 을 관리할 수 있도록 도와줍니다. 

Eric Evans 는 그의 저서 [Domain Driven Design-Tackling Complexity in
the Heart of Software](https://www.dddcommunity.org/book/evans_2003/) [-wikipedia](https://en.wikipedia.org/wiki/Domain-driven_design) 에서 aggregate 라는 개념을 소개하였습니다.

Aggregate 란 서로 관련 있는 도메인 모델의 집합을 의미합니다.

Aggregate 에는 크게 entity 와 value 로 구성됩니다.

이 둘은 식별성으로 구분할 수 있는데, entity 란 식별이 가능한 도메인 모델을 의미하며 value 는 식별할 필요가 없는 값 객체를 의미합니다.

식별성의 관점에서 entity 는 전역 식별자와 지역 식별자가 존재합니다.

- 전역 식별자 : Aggregate 외부에서 식별할 수 있음
- 지역 식별자 : Aggregate 내부에서 식별할 수 있음

Aggregate 내에서 domain model 의 일관성을 책임지는 특별한 entity 가 존재합니다. 이를 Aggregate Root 라는 이름으로 부릅니다. 

일관성을 위하여 Aggregate 에 접근하기 위해서는 Aggregate Root Entity 를 통해서만 접근할 수 있어야 합니다.

영속의 관점에서 본다면 Aggregate 는 영속될 때, Aggregate Root 의 id 만 노출하고 내부에 포함된 domain model 은 모두 data 혹은 value 로 취급합니다.

결국 Aggregate 가 Database 의 record 로 변경될 때, aggregate 를 json 으로 변경해도 무방하다는 것을 의미합니다.

이리하여 위의 컨셉을 이용한다면 data schema 구조를 고려하지 않는 순수 domain focused 개발이 가능해지고, 이 것을 지원하는 방법을 제공합니다

## 제공하는 기능

- AggregateRepository 를 이용한 편리한 영속화 방법 제공
- record version 을 이용한 낙관적 잠금을 통한 동시성 제어
- aggregate 데이터 구조에 대한 버전 관리

### References

- [The ideal ddd aggregate store - Vaughn Vernon, kalele](https://kalele.io/the-ideal-domain-driven-design-aggregate-store/)

