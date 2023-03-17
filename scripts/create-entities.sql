INSERT INTO car_brand(id, name)
values (1, 'Audi'),
       (2, 'BMW'),
       (3, 'Tesla'),
       (4, 'Chevrolet'),
       (5, 'Nissan'),
       (6, 'Porsche'),
       (7, 'Subaru'),
       (8, 'Toyota'),
       (9, 'Lexus');

INSERT INTO car(ID, CAR_BRAND_ID, MODEL)
VALUES (1, 1, 'R8'),
       (2, 1, 'A3'),
       (3, 2, 'X5'),
       (4, 2, 'M4 CSL'),
       (5, 3, 'Model S'),
       (6, 3, 'Model Z'),
       (7, 4, 'Camaro'),
       (8, 4, 'Tahoe'),
       (9, 5, 'GTR'),
       (10, 5, 'Skyline'),
       (11, 6, 'Cayenne'),
       (12, 6, '911'),
       (13, 7, 'Forester'),
       (14, 7, 'Impresa'),
       (15, 8, 'Camry'),
       (16, 8, 'Harrier'),
       (17, 9, 'RX200'),
       (18, 9, 'NX200');


INSERT INTO accessory(id, car_brand_id, photo, price, description, serial_number)
VALUES (1, 1,
        'https://avatars.mds.yandex.net/i?id=3c8e3c71263d3dc422c7adac1947b6bc-4937470-images-thumbs&n=13',
        5000, 'Чехлы для сидений', 1),

       (2, 2,
        'https://avatars.mds.yandex.net/i?id=e1381ae10b492bd659dd1d208a44d35a-5859969-images-thumbs&n=13',
        4000, 'Чехол для руля', 2),

       (3, 3,
        'https://ae04.alicdn.com/kf/HTB1Yhn4e4SYBuNjSsphq6zGvVXa1.jpg_500x500.jpg_.webp',
        1000, 'Пепельница', 3),

       (4, 4,
        'https://ae01.alicdn.com/kf/HTB1qRplXu6sK1RjSsrbq6xbDXXac/-.jpg',
        4000, 'Ящик на подлокотник', 4),

       (5, 5,
        'https://ae01.alicdn.com/kf/HTB1FEEpRFXXXXcvXXXXq6xXFXXXe.jpg?size=305784&height=570&width=800&hash=db39be2ce5df6098ef3bcb8ac19bf13d',
        2000, 'Органайзер на подлокотник', 5),

       (6, 6,
        'http://ae04.alicdn.com/kf/H4839b05b624a4476bb4e9adc9d01117fl/GEEAOK-2018.jpg',
        6000, 'Четкие чехлы', 6),

       (7, 7,
        'https://ae01.alicdn.com/kf/HTB18yUxXOfrK1RjSspbq6A4pFXaV.jpg',
        9000, 'Царские чехлы', 7),

       (8, 8,
        'https://ae04.alicdn.com/kf/Hd7777b69391c459dbbe1890261660941r.jpg',
        500, 'Уплотнитель для салона', 8),

       (9, 9,
        'https://ae01.alicdn.com/kf/H98ddbcf2ece74055a70a7e4159beeb8b9/-.jpg',
        1500, 'Держатель для телефона', 9);


INSERT INTO consumable(id, photo, price, description, serial_number)
VALUES (1,
        'https://avto-svecha.ru/images/collection/sticker/bosch-st-su-2-57cd835eae56d.jpg',
        500, 'Свечи зажигания bosh', 20),

       (2,
        'https://www.doctorguber.ru/upload/medialibrary/07d/v0zkwm145rihesdtfrdpvpqpnk58nh72/1-_-samogon.jpg',
        1000, 'Питьевая незамерзайка', 21),

       (3,
        'https://www.rti-prom.ru/wp-content/uploads/2020/04/chto-takoe-salnik-v-mashine.jpg',
        200, 'Сальники двух цветники', 22),

       (4, 'https://avatars.mds.yandex.net/get-mpic/4493022/img_id7618960774692218167.jpeg/orig',
        1000, 'Масло моторное Лукойл 5 литров', 23),

       (5,
        'https://corollafan.ru/wp-content/uploads/2014/12/Image-0064.jpg',
        550, 'Воздушный фильтр, почти не пахнет', 24),

       (6,
        'https://www.baltopttorg.ru/showimg_tmp.php?id=23312.jpg&wd=810&hd=810',
        900, 'Незамерзайка мятная 5 литров', 25),

       (7,
        'https://irecommend.ru/sites/default/files/product-images/503892/A3JQTFjF6BDRT5oAwD0OWQ.jpg',
        1200, 'Стекло омывающая жидкость со вкусом бабл гам', 26),

       (8,
        'https://i.avto.pro/newsimages/remen-grm.jpg',
        750, 'Ремень ГРМ', 27),

       (9,
        'https://m.onlinetrade.ru/img/items/m/liqui_moly_bremsenflussigkeit_dot_4_250_ml_134705_1.jpg',
        500, 'Тормозная жидкость 250 мл', 28),

       (10,
        'https://img.joomcdn.net/43025f8652dfd33fc690c806b69fd4af516d3edb_original.jpeg',
        250, 'Топливный фильтр', 29);

INSERT INTO car_part(id, photo, price, description, serial_number)
VALUES (1,
        'https://n-russia.ru/wp-content/uploads/f/4/1/f41cec9323c7077c3eaf9f46df562aa4.jpeg',
        100000, 'Двигатель в идеальном состоянии', 10),

       (2,
        'https://static.baza.drom.ru/v/1664616906736_block',
        8000, 'Точно не краденная фара', 11),

       (3,
        'https://s0.rbk.ru/v6_top_pics/media/img/1/56/756606484381561.jpg',
        16000, 'Калинвал прямо с завода', 12),
       (4,
        'https://cdn.izap24.ru/images/prodacts/sourse/185284/185284734_koleso-ford-mondeo-focus-r18-7-5j-et52-5-5x108.jpg',
        5000, 'Новое колесо ford', 13),

       (5,
        'https://volgadetal.ru/upload/iblock/159/aydinhn221rl7reel1jree0mqu249x00.jpg',
        4000, 'Карданный вал краденный', 14),

       (6,
        'https://avatars.mds.yandex.net/get-altay/236825/2a0000015e7a939c9d9cf9e98dc8cb646763/XXL',
        6000, 'Хромированная выхлопная труба', 15),

       (7,
        'https://asvrn.ru/images/stories/virtuemart/product/2101.png',
        1500, 'Двигательный поршень с разборки', 16),

       (8,
        'https://ru-minecraft.ru/uploads/posts/2012-09/1347819867_mod-1.png',
        3, 'Поршень из майнкрафт', 17),

       (9,
        'https://a.d-cd.net/98329cu-960.jpg',
        5500, 'Капот как новенький', 18),

       (10,
        'https://avtomag1.com/upload/iblock/529/a9a6ca7e-84e3-11e4-80d2-002590af40a9_5bc58d15-91d9-11e6-80d0-002590af40a9.jpeg',
        700, 'Решётка радиатора', 19);

INSERT INTO car_to_car_part(car_id, car_part_id)
    (SELECT c.id, cp.id
     FROM car c
              CROSS JOIN car_part cp);

INSERT INTO account(id, login, password)
VALUES (1, 'buyer1', 'buyer1'),
       (2, 'seller1', 'seller1'),
       (3, 'buyer2', 'buyer2'),
       (4, 'seller2', 'seller2'),
       (5, 'seller3', 'seller3');

INSERT INTO buyer(id, account_id)
VALUES (1, 1),
       (2, 3);

INSERT INTO seller(id, name, contact, account_id)
VALUES (1, 'Автозапчасти дёшево', '+7 (914) 103-86-31', 2),
       (2, 'Аксессуар мастер', '+7 (984) 107-71-87', 4),
       (3, 'Дядя Богдан', 'https://clck.ru/Vmr3g', 5);

INSERT INTO seller_accessory(seller_id, accessory_id, count) (SELECT 2, a.id, 3 from accessory a);

INSERT INTO seller_car_part(seller_id, car_part_id, count) (SELECT 1, cp.id, 3 from car_part cp);

INSERT INTO seller_consumable(seller_id, consumable_id, count) (SELECT 3, c.id, 3 from consumable c);
