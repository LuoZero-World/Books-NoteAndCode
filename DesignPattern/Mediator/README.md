Mediator模式：组员向仲裁者报告，仲裁者向组员下达指令
该模式目的在于“仲裁”，即将分散处理的逻辑集中起来，便于管理

通常情况下，面向对象编程可以帮助我们分散处理，避免过于集中；但在本例中，把逻辑判断(`colleagueChanged` `userpassChanged`)分散在各个类只会导致灾难。