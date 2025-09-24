create table if not exists `login` (
    `registrationNumber` varchar(100) not null,
    `password` varchar(100) not null,
    `studentStatus` varchar(100) not null,
    `logedIn` timestamp not null
)