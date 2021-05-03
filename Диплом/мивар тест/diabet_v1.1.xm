<model id="{acee70cd-1af2-4e89-abdb-52dfd0555bb4}" shortName="Model 1" formatXmlVersion="2.0" description="Model 1">
<class id="{adfbf3b3-4b3a-4e9d-8d16-a6aaa8c51a55}" shortName="Model 1">
<parameters/>
<rules>
<rule id="2cc94f1b-11f9-4059-a562-57a7facac8ae" shortName="Определение_клинической_картины_СД1" relation="ab9059c4-76ee-40bf-92f8-a9c3a6cfd86b" resultId="y:0d4613d1-e780-464f-8b36-7ba8db6f9249" initId="x3:1f829d9d-6321-46d2-b5f4-166bc20c4ed4;x1:df1148b7-832c-4d16-ad19-1d4dcb065d92;x4:499849d4-71c2-4669-87c5-a08c88c169e2;x2:ece80bcd-7d14-435e-b6c1-a1bf5c22814f" description="Если есть родственники с СД1 и/или если была перенесена вирусная инфеуция и/или стресс и/или перенесена перегрузка легкоусвояемыми углеводами (любые два), то имеется клиническая картина СД1"/>
<rule id="3e4750ff-c214-460d-beb1-52d14f8a4f99" shortName="Критерии_установления_СД_и_аутоантитела_СД1" relation="32ed77c2-13d4-4bde-a4da-cbc83f0c2802" resultId="y:b191d00d-c04e-407f-a7c8-137730e47317" initId="x1:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6;x2:75502fbd-739d-4d09-9e43-226e92da133e" description="Если есть критерии утсановления СД и есть аутоантитела СД1, то СД1"/>
<rule id="44322a60-931c-4f83-b380-ab1fa4eb5ebf" shortName="Критерии_установления_СД_и_пониженный_уровень_С_пептида" relation="71b9a69d-5c6c-48a3-bf46-0fa7c6b0c6c2" resultId="y:b191d00d-c04e-407f-a7c8-137730e47317" initId="x1:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6;x2:ea20809f-e0e9-494c-95e5-831c761244ec" description="Если критерии установления СД и пониженный уровень С-пептида, то СД1"/>
<rule id="46556efb-dc78-4bd1-8dd6-226a944df8ce" shortName="Критерии_установления_СД_и_клиническая_картина_СД2" relation="8376eeae-9ea6-4c4a-9a64-2ab2d2cb3c8f" resultId="y:c37f17d1-945c-46b9-bbc8-09fa1ef91c33" initId="x1:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6;x2:8dc1767a-02e0-4629-8ce3-c56945298281" description="Если критерии установления СД и клиническая картина СД2, то СД2"/>
<rule id="4a99f66a-f3aa-42b9-9816-1ea40b45ad5b" shortName="Определение_избытка_массы_тела" relation="9cb35b2e-53dc-437b-9718-de81f74c6d43" resultId="y:e12aede2-9e5f-40d2-86d7-10bfed60108f" initId="height:ee4c5035-f122-459b-b5f3-42cade41715e;weight:223210df-a274-4dcf-b251-e6e9f376e5eb;age:13a38e7c-706c-4f9b-9fec-1b6b8429317c" description="Если рост не соответствует росту, то наличие избытка массы тела"/>
<rule id="6c4dc5df-9682-49b3-bcc5-b05fb87bf770" shortName="Определение_классических_симптомов" relation="914423aa-e345-4c05-92f8-7f7abe88762f" resultId="y:6b173ed5-5289-422e-a990-79cbc998dc61" initId="x5:0a059404-115a-4261-ae36-973f66efa0eb;x3:f127f04b-9b1c-44ea-afac-08f22135c20d;x7:44f9610c-f9f8-404d-ac90-d29462fe562f;x8:380df6b2-4435-402b-99bf-735fb762faec;x1:205a45b4-42b5-4842-9d67-8a53cee10b50;x6:ccede1ee-d7eb-4694-b228-5ed65b71ee42;x9:aedf7d2f-95ed-4267-b4cb-63f11c934f53;x4:9e4d61d7-24e9-4f7e-97d1-0b4bf13c10ae;x2:8853d6a6-fabc-4d99-b583-cddb3ab97b28" description="Если есть жажда или запах ацетона в выдыхаемом воздухе или кожный зуд или учащенное мочеиспускание или плохое заживление ран или фурункулез или кандидоз или резкое снижение массы тела или повышенный аппетит, то имеются классические симптомы СД"/>
<rule id="6e0fb927-6e1e-4a01-943b-5d3aca852b2a" shortName="Отсутствие_аутоантител_СД1_и_критерии_установления_СД" relation="d66e71ca-2230-4d7b-95f4-a5efb68b35a1" resultId="y:c37f17d1-945c-46b9-bbc8-09fa1ef91c33" initId="x1:75502fbd-739d-4d09-9e43-226e92da133e;x2:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" description="Если нет аутоантител СД1 и есть критерии установления СД, то СД2"/>
<rule id="6f177388-27a8-422b-bfb5-20641dc47797" shortName="Определение_критериев_установления_СД_глюкоза_крови_натощак" relation="eee85553-77a5-426d-ac6f-b8ac4af456b1" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x:fe792c85-e481-4e7c-aacb-f115848029c7" description="Если уровень глюкозы в крови натощак >= 6,1 ммоль/л, то критерии установления СД"/>
<rule id="926b5e6f-f698-4219-b72e-60f06244efd3" shortName="Определение_критериев_установления_СД_гликированный_гемоглобин_крови" relation="1a760161-b305-401c-80ac-aa493c7d19de" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x:8aa3ff0c-1df6-49bb-9f53-4f2b91bc73d8" description="Если уровень гликированного гемоглобина в крови >= 6,5%, то имеются критерии установления СД"/>
<rule id="b20e962d-4322-449c-a815-1d20c14c7dd9" shortName="Определение_критериев_установления_СД_глюкоза_плазма_крови" relation="abc7651e-f02e-4395-b72a-0292143031e4" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x1:a97bcd1d-b719-4ba3-8561-28b3860969d8;x2:6b173ed5-5289-422e-a990-79cbc998dc61" description="Если имеются классические симптомы СД и концентрация глюкозы в плазме крови >= 11ммоль/л, то критерии установления СД"/>
<rule id="c1dcfa76-26a2-463e-a97e-0a52225c30cf" shortName="Определение_критериев_установления_СД_ООГТТ" relation="e046e773-75a5-42f9-86c3-ea7e1f025bb7" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x:00ff65f8-416d-4a4a-9a27-e4c17ec36a3b" description="Если уровень глюкозы >= 11,1 ммоль/л при проведении ОГТТ, то критерии установления СД"/>
<rule id="dcce0ef6-712a-42e6-bd03-bd6133038c30" shortName="Определение_критериев_определения_СД_глюкоза_крови" relation="abc7651e-f02e-4395-b72a-0292143031e4" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x1:12a7a7cd-6e1d-41bb-91e2-61901a6ec8d9;x2:6b173ed5-5289-422e-a990-79cbc998dc61" description="Если классические симптомы СД и концентрация глюкозы в крови >= 11 ммоль/л, то критерии установления СД"/>
<rule id="e3a32f05-9c2a-4f19-9b12-a499fcb467db" shortName="Определение_клинической_картины_СД2" relation="25d2cacd-c91b-4ded-84a4-0c595e1d2000" resultId="y:8dc1767a-02e0-4629-8ce3-c56945298281" initId="x3:b0391699-2118-4ab3-b407-7794e277822c;x1:e12aede2-9e5f-40d2-86d7-10bfed60108f;x4:13a38e7c-706c-4f9b-9fec-1b6b8429317c;x2:b4f1fd82-69bb-44d8-8aa5-2b2732c8105f" description="Если имеется избыток массы тела и/или родственники с СД2 и/или середина пубертатного возраста и/или возраст > 40 (любые два), то имеется клиническая картина СД2"/>
<rule id="eb0900f0-c50c-47af-9c35-9625c241c19b" shortName="Критерии_установления_СД_и_повышенный_уровень_С_пептида" relation="71b9a69d-5c6c-48a3-bf46-0fa7c6b0c6c2" resultId="y:c37f17d1-945c-46b9-bbc8-09fa1ef91c33" initId="x1:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6;x2:25186d48-e41c-498f-901f-4dffa2067b74" description="Если критерии установления СД и повышенный уровень С-пептида, то СД2"/>
<rule id="f1dcbdde-6ccf-4614-8f14-2a9323a2d4b0" shortName="Определение_пубертатного_возраста" relation="ceefa6b5-3a50-4efd-8da1-c044b28d653f" resultId="y:b0391699-2118-4ab3-b407-7794e277822c" initId="sex:5ef29075-3174-4cf4-a45a-ac30041b9148;age:13a38e7c-706c-4f9b-9fec-1b6b8429317c" description="Если пол женский и возраст от 9 до 16 или пол мужской и возраст от 11 до 19, то середина пубертатного возраста"/>
<rule id="f5bc51d8-5ed7-49f9-b4c3-7fbac1b7523e" shortName="Критерии_установления_СД_и_клиническая_картина_СД1" relation="8376eeae-9ea6-4c4a-9a64-2ab2d2cb3c8f" resultId="y:b191d00d-c04e-407f-a7c8-137730e47317" initId="x1:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6;x2:0d4613d1-e780-464f-8b36-7ba8db6f9249" description="Если критерии установления СД и клиническая картина СД1, то СД1"/>
<rule id="fe2b825b-8ed6-4ae6-a0a2-1bccd6cb2db1" shortName="Определение_критериев_установления_СД_глюкоза_плазмы_крови_натощак" relation="2b8ee0c3-f3f5-4241-aaeb-23c9b443c1a8" resultId="y:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" initId="x:11ce1809-8928-41f2-9d30-d833de6df443" description="Если уровень глюкозы в плазме крови натощак >= 7,0 ммоль/л то критерии установления СД"/>
</rules>
<constraints/>
<classes>
<class id="339841d4-4cb5-46c4-ba2d-f099d0119e34" shortName="Диагноз" description="Данные о наличие СД1 или СД2 у пациента">
<parameters>
<parameter id="504e560f-9a70-42db-96e3-126419912e83" shortName="Нет СД" description="Отсутствие у пациента сахарного диабета 1-го или 2-го типа" type="double"/>
<parameter id="b191d00d-c04e-407f-a7c8-137730e47317" shortName="СД1" description="Наличие у пациента сахарного диабета 1-го типа" type="double"/>
<parameter id="c053acb2-ad1f-4412-8971-4fc1d6ffe9d9" shortName="Название диагноза" defaultValue="" description="Текстовое описание диагноза" type="string"/>
<parameter id="c37f17d1-945c-46b9-bbc8-09fa1ef91c33" shortName="СД2" description="Наличие у пациента сахарного диабета 2-го типа" type="double"/>
</parameters>
<rules>
<rule id="4f722270-6c05-4de9-a001-5a6be9172aed" shortName="Определение_отсутствия_СД" relation="bb2cc9ff-b25d-471a-9422-163ea5c430bb" resultId="y:504e560f-9a70-42db-96e3-126419912e83" initId="x1:b191d00d-c04e-407f-a7c8-137730e47317;x2:c37f17d1-945c-46b9-bbc8-09fa1ef91c33" description="Если нет СД1 и нет СД2, то нет СД"/>
<rule id="7067e598-d9d7-4828-aa3c-5a4b240bd2be" shortName="Определение_названия_диагноза" relation="ecd320a8-6b0d-465a-abec-c4bded527b1d" resultId="y:c053acb2-ad1f-4412-8971-4fc1d6ffe9d9" initId="x3:504e560f-9a70-42db-96e3-126419912e83;x1:b191d00d-c04e-407f-a7c8-137730e47317;x2:c37f17d1-945c-46b9-bbc8-09fa1ef91c33"/>
</rules>
<constraints>
<constraint id="0764f62b-ce80-4048-a416-d1902180fd52" shortName="Ограничение_bool_СД2" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:c37f17d1-945c-46b9-bbc8-09fa1ef91c33"/>
<constraint id="7aaf9b13-1026-4077-a3f1-6b1dc4b6f2bc" shortName="Ограничение_bool_Нет_СД" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:504e560f-9a70-42db-96e3-126419912e83"/>
<constraint id="97f00229-0c09-4d16-a901-5ec8d04f52a0" shortName="Ограничение_bool_СД1" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:b191d00d-c04e-407f-a7c8-137730e47317"/>
</constraints>
<classes/>
</class>
<class id="3531d1fd-f13f-42a7-83bf-18a1e94ae079" shortName="Отягощающие факторы" description="Факторы риска развития сахарного диабета">
<parameters>
<parameter id="1f829d9d-6321-46d2-b5f4-166bc20c4ed4" shortName="Стресс" description="Был ли пациентом перенесен стресс" type="double"/>
<parameter id="499849d4-71c2-4669-87c5-a08c88c169e2" shortName="Перегрузка углеводами" description="Была ли пациентом перенесена перегрузка легкоусвояемыми углеводами" type="double"/>
<parameter id="b0391699-2118-4ab3-b407-7794e277822c" shortName="Середина пубертатного периода" description="Находится ли пациент в пубертатном периоде" type="double"/>
<parameter id="b4f1fd82-69bb-44d8-8aa5-2b2732c8105f" shortName="Родственники СД2" description="Имеются ли у пациента родственники с сахарным диабетом 2-го типа" type="double"/>
<parameter id="df1148b7-832c-4d16-ad19-1d4dcb065d92" shortName="Родственники СД1" description="Имеются ли у пациента родственники с сахарным диабетом 1-го типа" type="double"/>
<parameter id="e12aede2-9e5f-40d2-86d7-10bfed60108f" shortName="Избыток массы тела" description="Имеетмя ли у пациента избыток массы тела" type="double"/>
<parameter id="ece80bcd-7d14-435e-b6c1-a1bf5c22814f" shortName="Вирусная инфекция" description="Была ли пациентом перенесена вирусная инфекция" type="double"/>
</parameters>
<rules/>
<constraints>
<constraint id="29f7a58e-80bb-41a1-acf1-63d76a95f719" shortName="Ограничение_bool_Стресс" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:1f829d9d-6321-46d2-b5f4-166bc20c4ed4"/>
<constraint id="4b7db1b8-b5c7-4dac-8ff2-27129d2019ed" shortName="Ограничение_bool_Вирусная_инфекция" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:ece80bcd-7d14-435e-b6c1-a1bf5c22814f"/>
<constraint id="69b573fc-97d4-4542-a43b-7138c80e1697" shortName="Ограничение_bool_Середина_пубертатного_периода" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:b0391699-2118-4ab3-b407-7794e277822c"/>
<constraint id="848a8818-54d0-42d9-b682-c5f671faea50" shortName="Ограничение_bool_Родственники_СД2" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:b4f1fd82-69bb-44d8-8aa5-2b2732c8105f"/>
<constraint id="bdb3fa70-2b75-4df5-a0b8-7f03edabcb60" shortName="Ограничение_bool_Избыток_массы_тела" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:e12aede2-9e5f-40d2-86d7-10bfed60108f"/>
<constraint id="bebee85d-b56e-4599-8cc7-8ca07e58c7d8" shortName="Ограничение_bool_Перегрузка_углеводами" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:499849d4-71c2-4669-87c5-a08c88c169e2"/>
<constraint id="eb56e2be-ea2e-404b-a023-119e9e2c491b" shortName="Ограничение_bool_Родственники_СД1" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:df1148b7-832c-4d16-ad19-1d4dcb065d92"/>
</constraints>
<classes/>
</class>
<class id="7f592c24-1283-490b-b2ee-19249aff8925" shortName="Анализ крови" description="Результаты анализа крови">
<parameters>
<parameter id="00ff65f8-416d-4a4a-9a27-e4c17ec36a3b" shortName="Концентрация глюкозы ОГТТ молль л" description="Концентрация глюкозы при проведении ОГТТ теста молль/л" type="double"/>
<parameter id="11ce1809-8928-41f2-9d30-d833de6df443" shortName="Концентрация глюкозы в плазме крови натощак молль л" description="Концентрация глюкозы в плазме крови натощак, молль/л" type="double"/>
<parameter id="12a7a7cd-6e1d-41bb-91e2-61901a6ec8d9" shortName="Концентрация глюкозы в крови молль л" description="Концентрация глюкозы в крови, ммоль/л" type="double"/>
<parameter id="14702f00-d0ce-41fb-b93a-f1433177b769" shortName="Концентрация глюкозы в крови натощак мг дл" description="Концентрация глюкозы в крови натощак мг/дл" type="double"/>
<parameter id="25186d48-e41c-498f-901f-4dffa2067b74" shortName="Повышенный уровень С-пептида" description="Повышенный уровень С-пептида в крови" type="double"/>
<parameter id="39e54fcf-777f-4c86-ace4-2d709321b7f8" shortName="Концентрация глюкозы ОГТТ мг дл" description="Концентрация глюкозы при проведении ОГТТ теста, мг/дл" type="double"/>
<parameter id="432d46f1-bb21-4013-8d02-935181da7d3a" shortName="Уровень С-пептида нг мл" description="С-пептид, нг/мл" type="double"/>
<parameter id="5126f33b-aa32-4334-a5ee-d222409551a2" shortName="Концентрация глюкозы в плазме крови натощак мг дл" description="Концентрация глюкозы в плазме крови натощак, мг/дл" type="double"/>
<parameter id="75502fbd-739d-4d09-9e43-226e92da133e" shortName="Аутоантитела СД1" description="Наличие аутоантител сахарного диабета 1-го типа в крови" type="double"/>
<parameter id="8aa3ff0c-1df6-49bb-9f53-4f2b91bc73d8" shortName="Уровень гликированного гемоглобина в крови" description="%" type="double"/>
<parameter id="a97bcd1d-b719-4ba3-8561-28b3860969d8" shortName="Концентрация глюкозы в плазме крови молль л" description="Концентрация глюкозы в плазме крови, молль/л" type="double"/>
<parameter id="e8ff6927-2a98-4d46-b12e-b1010df5901a" shortName="Концентрация глюкозы в плазме крови мг дл" description="Концентрация глюкозы в плазме крови, мг/дл" type="double"/>
<parameter id="e9b80f8a-231e-4350-9dd6-d0ee138aeebb" shortName="Концентрация глюкозы в крови мг дл" description="Концентрация глюкозы в крови мг дл" type="double"/>
<parameter id="ea20809f-e0e9-494c-95e5-831c761244ec" shortName="Пониженный уровень С-пептида" description="Пониженный уровень С_пептида в крови" type="double"/>
<parameter id="fe792c85-e481-4e7c-aacb-f115848029c7" shortName="Концентрация глюкозы в крови натощак молль л" description="Концентрация глюкозы в крови натощак, молль/л" type="double"/>
</parameters>
<rules>
<rule id="1c1be825-80db-46e1-a4a5-f538485c2f67" shortName="Пересчет_из_мг_дл_в_ммоль_л_Концентрация_глюкозы_в_плазме_крови_натощак" relation="08287f48-ce02-4c28-8a26-7dae5ec90e3b" resultId="y:11ce1809-8928-41f2-9d30-d833de6df443" initId="x:5126f33b-aa32-4334-a5ee-d222409551a2" description="Перевод глюкозы из мг/дл в ммоль/л: мг/дл /18,02 = ммоль/л"/>
<rule id="524dfe47-15ed-41b5-820e-95aae4736232" shortName="Пересчет_из_мг_дл_в_ммоль_л_Концентрация_глюкозы_в_плазме_крови" relation="08287f48-ce02-4c28-8a26-7dae5ec90e3b" resultId="y:a97bcd1d-b719-4ba3-8561-28b3860969d8" initId="x:e8ff6927-2a98-4d46-b12e-b1010df5901a" description="Перевод глюкозы из мг/дл в ммоль/л: мг/дл /18,02 = ммоль/л"/>
<rule id="6c85828f-a822-4109-b1f0-d1b7f85fe60f" shortName="Определение_повышенного_уровня_С_пептида" relation="5fee2f6d-5938-4216-b3ef-91caf484fb59" resultId="y:25186d48-e41c-498f-901f-4dffa2067b74" initId="x:432d46f1-bb21-4013-8d02-935181da7d3a" description="Если базальный уровень С-пептида > 4,4 нг/мл, то уровень С-пептида повышен"/>
<rule id="70bad49f-11b8-436b-ac4c-6b2c7a46cef2" shortName="Пересчет_из_мг_дл_в_ммоль_л_Концентрация_глюкозы_в_крови_натощак" relation="08287f48-ce02-4c28-8a26-7dae5ec90e3b" resultId="y:fe792c85-e481-4e7c-aacb-f115848029c7" initId="x:14702f00-d0ce-41fb-b93a-f1433177b769" description="Перевод глюкозы из мг/дл в ммоль/л: мг/дл /18,02 = ммоль/л"/>
<rule id="710c5ca2-518d-4d5a-be94-44377e59f2cf" shortName="Определение_пониженного_уровня_С_пептида" relation="d72d6052-1e38-4fe5-8d6a-092a61eba20e" resultId="y:ea20809f-e0e9-494c-95e5-831c761244ec" initId="x:432d46f1-bb21-4013-8d02-935181da7d3a" description="Если базальный уровень С-пептида &lt; 1,1 нг/мл, то уровень С-пептида понижен"/>
<rule id="d1101e3d-e011-4098-9640-b6306eda88ed" shortName="Пересчет_из_мг_дл_в_ммоль_л_Концентрация_глюкозы_ОГТТ" relation="08287f48-ce02-4c28-8a26-7dae5ec90e3b" resultId="y:00ff65f8-416d-4a4a-9a27-e4c17ec36a3b" initId="x:39e54fcf-777f-4c86-ace4-2d709321b7f8" description="Перевод глюкозы из мг/дл в ммоль/л: мг/дл /18,02 = ммоль/л"/>
<rule id="f172e7e7-91ee-4fc5-9293-eb697bb658ec" shortName="Пересчет_из_мг_дл_в_ммоль_л_Концентрация_глюкозы_в_крови" relation="08287f48-ce02-4c28-8a26-7dae5ec90e3b" resultId="y:12a7a7cd-6e1d-41bb-91e2-61901a6ec8d9" initId="x:e9b80f8a-231e-4350-9dd6-d0ee138aeebb" description="Перевод глюкозы из мг/дл в ммоль/л: мг/дл /18,02 = ммоль/л"/>
</rules>
<constraints>
<constraint id="00e9f022-cdc4-4f12-a64c-9f287027abe9" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_плазме_крови_молль_л" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:a97bcd1d-b719-4ba3-8561-28b3860969d8"/>
<constraint id="02e70f78-0b45-467a-b4d8-7e30a0415ada" shortName="Ограничение_bool_Повышенный_уровень_С_пептида" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:25186d48-e41c-498f-901f-4dffa2067b74"/>
<constraint id="14e21da5-19ca-4365-bfe6-50266669352d" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_плазме_крови_натощак_молль_л" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:11ce1809-8928-41f2-9d30-d833de6df443"/>
<constraint id="19f6e2cb-ad5c-4af7-8df4-151a2a31f90f" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_ОГТТ_молль_л" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:00ff65f8-416d-4a4a-9a27-e4c17ec36a3b"/>
<constraint id="4cd8336f-4777-4f2c-8f99-5fa9bde3c27e" shortName="Ограничение_неотрицательные_значения_Уровень_С_пептида" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:432d46f1-bb21-4013-8d02-935181da7d3a"/>
<constraint id="4d05d7b6-ed5c-42fd-bbe4-e7c0ac396d82" shortName="Ограничение_bool_Пониженный_уровень_С_пептида" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:ea20809f-e0e9-494c-95e5-831c761244ec"/>
<constraint id="4dd50d8d-e7dc-4795-acca-8ccc8981acd0" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_крови_ммоль_л" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:12a7a7cd-6e1d-41bb-91e2-61901a6ec8d9"/>
<constraint id="589c645a-0cc9-4154-b8b3-97357579d387" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_плазме_крови_натощак_мг_дл" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:5126f33b-aa32-4334-a5ee-d222409551a2"/>
<constraint id="6d10f0b1-f6e6-4f25-8003-457f67466200" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_крови_натощак_мг_дл" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:14702f00-d0ce-41fb-b93a-f1433177b769"/>
<constraint id="747955e6-7d4e-4bc8-b46e-3a540292680a" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_плазме_крови_мг_дл" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:e8ff6927-2a98-4d46-b12e-b1010df5901a"/>
<constraint id="74e27d68-75aa-4241-92d7-0da56c372dcf" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_ОГТТ_мг_дл" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:39e54fcf-777f-4c86-ace4-2d709321b7f8"/>
<constraint id="86ef2cda-76f4-494c-a2aa-7e091bae8f70" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_крови_мг_дл" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:e9b80f8a-231e-4350-9dd6-d0ee138aeebb"/>
<constraint id="d2471fa5-549a-4197-b8a9-748897679e32" shortName="Ограничение_bool_Аутоантитела_СД1" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:75502fbd-739d-4d09-9e43-226e92da133e"/>
<constraint id="d8c1b0b7-80bd-4af8-b6b4-6b12839b4046" shortName="Ограничение_проценты_Уровень_гликированного_гемоглобина_в_крови" relation="8450f236-d78d-4f3a-af82-4dcac7782c9d" initId="x:8aa3ff0c-1df6-49bb-9f53-4f2b91bc73d8"/>
<constraint id="e4d20464-9c20-48ed-be62-f9bd176cd0c2" shortName="Ограничение_неотрицательные_значения_Концентрация_глюкозы_в_крови_натощак_молль_л" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:fe792c85-e481-4e7c-aacb-f115848029c7"/>
</constraints>
<classes/>
</class>
<class id="9fefaf4e-2696-47a8-8fc6-dba60ab84ea5" shortName="Характеристики пациента" description="Данные, которые можно получить от пациента, при осмотре или общении">
<parameters>
<parameter id="13a38e7c-706c-4f9b-9fec-1b6b8429317c" shortName="Возраст" description="Возраст пациента" type="double"/>
<parameter id="223210df-a274-4dcf-b251-e6e9f376e5eb" shortName="Вес" description="Вес пациента, кг" type="double"/>
<parameter id="5ef29075-3174-4cf4-a45a-ac30041b9148" shortName="Пол" description="Пол пациента" type="string"/>
<parameter id="ee4c5035-f122-459b-b5f3-42cade41715e" shortName="Рост" description="Рост пациента, м" type="double"/>
</parameters>
<rules/>
<constraints>
<constraint id="08a8833e-cc6b-41d6-be28-a4a596dc9eff" shortName="Ограничение_пол" relation="5548643d-fc56-4ac7-9920-f77d05a6b836" initId="x:5ef29075-3174-4cf4-a45a-ac30041b9148"/>
<constraint id="1ca486f6-8994-420f-8b6b-67bc8ec0f507" shortName="Ограничение_положительного_значения_рост" relation="2425c77f-4dac-4ed9-8026-cfd047959760" initId="x:ee4c5035-f122-459b-b5f3-42cade41715e"/>
<constraint id="6250c871-fd44-494e-a78d-e4f6a1093573" shortName="Ограничение_неотрицательные_значения_Возраст" relation="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" initId="x:13a38e7c-706c-4f9b-9fec-1b6b8429317c"/>
<constraint id="855b62fd-8f73-4f52-9a9b-ad7b4bdcdf29" shortName="Ограничение_положительного_значения_Вес" relation="2425c77f-4dac-4ed9-8026-cfd047959760" initId="x:223210df-a274-4dcf-b251-e6e9f376e5eb"/>
</constraints>
<classes/>
</class>
<class id="ae3a4a47-fab6-464b-9cd7-4475f05e453f" shortName="Симптомы" description="Данные о симптомах, выявленных у пациента">
<parameters>
<parameter id="0a059404-115a-4261-ae36-973f66efa0eb" shortName="Плохое заживление ран" type="double"/>
<parameter id="205a45b4-42b5-4842-9d67-8a53cee10b50" shortName="Жажда" type="double"/>
<parameter id="380df6b2-4435-402b-99bf-735fb762faec" shortName="Резкое снижение массы тела" description="Резкое и значительное снижение массы тела" type="double"/>
<parameter id="44f9610c-f9f8-404d-ac90-d29462fe562f" shortName="Кандидоз" type="double"/>
<parameter id="8853d6a6-fabc-4d99-b583-cddb3ab97b28" shortName="Запах ацетона" description="Запах ацетона в выдыхаемом воздухе" type="double"/>
<parameter id="9e4d61d7-24e9-4f7e-97d1-0b4bf13c10ae" shortName="Учащенное мочеиспускание" type="double"/>
<parameter id="aedf7d2f-95ed-4267-b4cb-63f11c934f53" shortName="Повышенный аппетит" type="double"/>
<parameter id="ccede1ee-d7eb-4694-b228-5ed65b71ee42" shortName="Фурункулез" type="double"/>
<parameter id="f127f04b-9b1c-44ea-afac-08f22135c20d" shortName="Кожнный зуд" type="double"/>
</parameters>
<rules/>
<constraints>
<constraint id="03278933-35ad-4296-ac3b-5b0c22df013e" shortName="Ограничение_bool_Резкое_снижение_массы_тела" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:380df6b2-4435-402b-99bf-735fb762faec"/>
<constraint id="5588bafb-ab1e-48f8-9a57-aad158ecf7f6" shortName="Ограничение_bool_Учащенное_мочеиспускание" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:9e4d61d7-24e9-4f7e-97d1-0b4bf13c10ae"/>
<constraint id="97365a56-5668-4c74-801f-c6380319b2cd" shortName="Ограничение_bool_Жажда" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:205a45b4-42b5-4842-9d67-8a53cee10b50"/>
<constraint id="c48938fd-8994-4658-9c2b-ef8662e28ed5" shortName="Ограничение_bool_Фурункулез" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:ccede1ee-d7eb-4694-b228-5ed65b71ee42"/>
<constraint id="e3d480cd-4f14-4ab7-80ac-5ac56e5feb94" shortName="Ограничение_bool_Кандидоз" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:44f9610c-f9f8-404d-ac90-d29462fe562f"/>
<constraint id="ec767c6f-cb9d-41d4-b521-e07506e23e32" shortName="Ограничение_bool_Кожнный_зуд" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:f127f04b-9b1c-44ea-afac-08f22135c20d"/>
<constraint id="f064ae04-cc84-4d81-8094-0010d3ca2980" shortName="Ограничение_bool_Плохое_заживление_ран" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:0a059404-115a-4261-ae36-973f66efa0eb"/>
<constraint id="f86ef6dc-1d98-420e-b8bb-e39b4ad1bbb2" shortName="Ограничение_bool_Запах_ацетона" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:8853d6a6-fabc-4d99-b583-cddb3ab97b28"/>
<constraint id="fe0cd06a-fab1-41e6-be4e-b0438a87638a" shortName="Ограничение_bool_Повышенный_аппетит" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:aedf7d2f-95ed-4267-b4cb-63f11c934f53"/>
</constraints>
<classes/>
</class>
<class id="b4f62880-5458-499d-8098-836a8c2c28a5" shortName="Предварительный диагноз">
<parameters>
<parameter id="0d4613d1-e780-464f-8b36-7ba8db6f9249" shortName="Клиническая картина СД1" type="double"/>
<parameter id="6b173ed5-5289-422e-a990-79cbc998dc61" shortName="Классические симптомы СД" description="Наличие у пациента классических симптомов сахарного диабета" type="double"/>
<parameter id="8dc1767a-02e0-4629-8ce3-c56945298281" shortName="Клиническая картина СД2" type="double"/>
<parameter id="8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6" shortName="Критерии установления СД" description="Имеются ли у пациента критерии установления сахарного диабета" type="double"/>
</parameters>
<rules/>
<constraints>
<constraint id="5fa11c7d-eb00-4d18-a77a-ee29918ffc6e" shortName="Ограничение_bool_Клиническая_картина_СД2" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:8dc1767a-02e0-4629-8ce3-c56945298281"/>
<constraint id="b6a4f633-f0fb-4900-83f4-c6d025552dc5" shortName="Ограничение_bool_Критерии_установления_СД" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:8f9f9b3c-1b4a-40ae-a5ba-84651b6384a6"/>
<constraint id="c22b7cc2-90bc-4378-b3fd-92294362b2e9" shortName="Ограничение_bool_Клиническая_картина_СД1" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:0d4613d1-e780-464f-8b36-7ba8db6f9249"/>
<constraint id="f9122fa3-903b-4022-8f9c-eeae283c1d3a" shortName="Ограничение_bool_Классические_симптомы_СД" relation="8ac8a004-9780-488d-8fda-c0fcb1533faa" initId="x:6b173ed5-5289-422e-a990-79cbc998dc61"/>
</constraints>
<classes/>
</class>
</classes>
</class>
<relations>
<relation id="08287f48-ce02-4c28-8a26-7dae5ec90e3b" shortName="Пересчет_из_мг_дл_в_ммоль_л" inObj="x:double" relationType="simple" outObj="y:double">y = x / 18.2</relation>
<relation id="1a760161-b305-401c-80ac-aa493c7d19de" shortName="Определение_критериев_установления_СД_гликированный_гемоглобин_крови" inObj="x:double" relationType="prog" outObj="y:double">var x,  y;&#xd;&#xd;&#xd;&#xd;
if( x >= 6.5 ){&#xd;&#xd;&#xd;&#xd;
y = 1;&#xd;&#xd;&#xd;&#xd;
} else {&#xd;&#xd;&#xd;&#xd;
y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="2425c77f-4dac-4ed9-8026-cfd047959760" shortName="Ограничение_положительные_значения" inObj="x:double" relationType="constr" outObj="flag:double">if (x>0) {flag = true;} else {flag = false;}</relation>
<relation id="25d2cacd-c91b-4ded-84a4-0c595e1d2000" shortName="Определение_клинической_картины_СД2" inObj="x3:double;x1:double;x4:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, x3, x4;&#xd;&#xd;&#xd;&#xd;
if( x1 &amp;&amp; x2 || x1 &amp;&amp; x3 || x1 &amp;&amp; (x4>40) || x2 &amp;&amp; x3 || x2 &amp;&amp; (x4>40) || x3 &amp;&amp; (x4>40) ){&#xd;&#xd;&#xd;&#xd;
y = 1;&#xd;&#xd;&#xd;&#xd;
}else{&#xd;&#xd;&#xd;&#xd;
y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="2b8ee0c3-f3f5-4241-aaeb-23c9b443c1a8" shortName="Определение_критериев_установления_СД_глюкоза_плазмы_крови_натощак" inObj="x:double" relationType="prog" outObj="y:double">var x, y;&#xd;&#xd;&#xd;&#xd;
if( x >= 7.0 )&#xd;&#xd;&#xd;&#xd;
{&#xd;&#xd;&#xd;&#xd;
    y = 1;&#xd;&#xd;&#xd;&#xd;
} else {&#xd;&#xd;&#xd;&#xd;
    y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="32ed77c2-13d4-4bde-a4da-cbc83f0c2802" shortName="Критерии_установления_СД_и_аутоантитела_СД1" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, y;&#xd;&#xd;
if((x1 == 1) &amp;&amp; (x2 == 1)){&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="5548643d-fc56-4ac7-9920-f77d05a6b836" shortName="Ограничение_пол" inObj="x:string" relationType="constr" outObj="flag:double">if (x=='мужской' || x == 'женский') {flag = true;} else {flag = false;}</relation>
<relation id="5fee2f6d-5938-4216-b3ef-91caf484fb59" shortName="Определение_повышенного_уровня_С_пептида" inObj="x:double" relationType="prog" outObj="y:double">var x, y;&#xd;&#xd;
if( x > 4.4 ) {&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="71b9a69d-5c6c-48a3-bf46-0fa7c6b0c6c2" shortName="Критерии_установления_СД_и_уровень_С_пептида" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, y;&#xd;&#xd;
if((x1 == 1)&amp;&amp;(x2 == 1)){&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="8376eeae-9ea6-4c4a-9a64-2ab2d2cb3c8f" shortName="Критерии_установления_СД_и_клиническая_картина" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2;&#xd;&#xd;
if( (x1 == 1) &amp;&amp; (x2 == 1) ){&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="8450f236-d78d-4f3a-af82-4dcac7782c9d" shortName="Ограничение_проценты" inObj="x:double" relationType="constr" outObj="flag:double">if (x >= 0 &amp;&amp; x &lt;= 100) {flag = true;} else {flag = false;}</relation>
<relation id="8ac8a004-9780-488d-8fda-c0fcb1533faa" shortName="Ограничение_bool" inObj="x:double" relationType="constr" outObj="flag:double">if (x == 0 || x == 1) {flag = true;} else {flag = false;}</relation>
<relation id="914423aa-e345-4c05-92f8-7f7abe88762f" shortName="Определение_классических_симптомов" inObj="x5:double;x3:double;x7:double;x8:double;x1:double;x6:double;x9:double;x4:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, x3, x4, x5, x6, x7, x8, x9, y;&#xd;&#xd;
if( (x1==1) || (x2==1) || (x3 == 1) || (x4 == 1) || (x5==1) || (x6 == 1) || (x7==1) || (x8==1) || (x9 ==1) ){&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="9cb35b2e-53dc-437b-9718-de81f74c6d43" shortName="Определение_избытка_массы_тела" inObj="height:double;weight:double;age:double" relationType="prog" outObj="y:double">var height, weight, age, y;&#xd;&#xd;&#xd;&#xd;
if( weight / ( height * height ) >= 25)&#xd;&#xd;&#xd;&#xd;
{&#xd;&#xd;&#xd;&#xd;
y = 1;&#xd;&#xd;&#xd;&#xd;
}else&#xd;&#xd;&#xd;&#xd;
{&#xd;&#xd;&#xd;&#xd;
y = 0;&#xd;&#xd;&#xd;&#xd;
}&#xd;&#xd;&#xd;&#xd;
</relation>
<relation id="ab9059c4-76ee-40bf-92f8-a9c3a6cfd86b" shortName="Определение_клинической_картины_СД1" inObj="x3:double;x1:double;x4:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, x3, x4, y;&#xd;
if( x1 &amp;&amp; x2 || x1 &amp;&amp; x3 || x1 &amp;&amp; x4 || x2 &amp;&amp; x3 || x2 &amp;&amp; x4 ||x3 &amp;&amp; x4 ){&#xd;
    y = 1;&#xd;
}else{&#xd;
    y = 0;&#xd;
}</relation>
<relation id="abc7651e-f02e-4395-b72a-0292143031e4" shortName="Определение_критериев_установления_СД_глюкоза" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, y;&#xd;&#xd;&#xd;&#xd;
if ( (x1 >=11.1) &amp;&amp; (x2 == 1) ){&#xd;&#xd;&#xd;&#xd;
    y = 1;&#xd;&#xd;&#xd;&#xd;
} else {&#xd;&#xd;&#xd;&#xd;
    y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="bb2cc9ff-b25d-471a-9422-163ea5c430bb" shortName="Определение_отсутствия_СД" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, y;&#xd;
if( (x1 == 0) &amp;&amp; (x2 == 0) ){&#xd;
    y = 1;&#xd;
} else {&#xd;
    y = 0;&#xd;
}</relation>
<relation id="ceefa6b5-3a50-4efd-8da1-c044b28d653f" shortName="Определение_пубертатного_возраста" inObj="sex:string;age:double" relationType="prog" outObj="y:double">var sex, age, y;&#xd;&#xd;&#xd;&#xd;
if( sex == 'мужской' ){&#xd;&#xd;&#xd;&#xd;
    if ((age > 11) &amp;&amp; (age &lt; 19))&#xd;&#xd;&#xd;&#xd;
    {&#xd;&#xd;&#xd;&#xd;
        y = 1;&#xd;&#xd;&#xd;&#xd;
    }else{&#xd;&#xd;&#xd;&#xd;
        y = 0;&#xd;&#xd;&#xd;&#xd;
    }&#xd;&#xd;&#xd;&#xd;
}&#xd;&#xd;&#xd;&#xd;
if( sex == 'женский' ){&#xd;&#xd;&#xd;&#xd;
    if ((age > 9) &amp;&amp; (age &lt; 16))&#xd;&#xd;&#xd;&#xd;
    {&#xd;&#xd;&#xd;&#xd;
        y = 1;&#xd;&#xd;&#xd;&#xd;
    }else{&#xd;&#xd;&#xd;&#xd;
        y = 0;&#xd;&#xd;&#xd;&#xd;
    }&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="d66e71ca-2230-4d7b-95f4-a5efb68b35a1" shortName="Отсутствие_аутоантител_СД1_и_критерии_установления_СД" inObj="x1:double;x2:double" relationType="prog" outObj="y:double">var x1, x2, y;&#xd;&#xd;
if((x1 == 0) &amp;&amp; (x2 == 1) )&#xd;&#xd;
{&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="d72d6052-1e38-4fe5-8d6a-092a61eba20e" shortName="Определение_пониженного_уровня_С_пептида" inObj="x:double" relationType="prog" outObj="y:double">var x, y;&#xd;&#xd;
if( x &lt; 1.1 ){&#xd;&#xd;
    y = 1;&#xd;&#xd;
} else {&#xd;&#xd;
    y = 0;&#xd;&#xd;
}</relation>
<relation id="e046e773-75a5-42f9-86c3-ea7e1f025bb7" shortName="Определение_критериев_установления_СД_ООГТТ" inObj="x:double" relationType="prog" outObj="y:double">var x, y;&#xd;&#xd;&#xd;&#xd;
if( x >= 11.1)&#xd;&#xd;&#xd;&#xd;
{&#xd;&#xd;&#xd;&#xd;
    y = 1;&#xd;&#xd;&#xd;&#xd;
}else{&#xd;&#xd;&#xd;&#xd;
    y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
<relation id="e6f457a0-6ecb-4123-95f9-83c23f7df8fa" shortName="Ограничение_неотрицательные_значения" inObj="x:double" relationType="constr" outObj="flag:double">if (x>=0) {flag = true;} else {flag = false;}</relation>
<relation id="ecd320a8-6b0d-465a-abec-c4bded527b1d" shortName="Определение_названия_диагноза" inObj="x3:double;x1:double;x2:double" relationType="prog" outObj="y:string">var x1, x2, x3, y;
if(x1 == 1){
    y = 'Сахарный диабет 1-го типа';
} else if(x2 == 1){
    y = 'Сахарный диабет 2-го типа';
} else if(x3 == 1){
    y = 'Нет сахарного диабета 1-го или 2-го типа';
}</relation>
<relation id="eee85553-77a5-426d-ac6f-b8ac4af456b1" shortName="Определение_критериев_установления_СД_глюкоза_крови_натощак" inObj="x:double" relationType="prog" outObj="y:double">var x, y;&#xd;&#xd;&#xd;&#xd;
if( x >= 6.1 )&#xd;&#xd;&#xd;&#xd;
{&#xd;&#xd;&#xd;&#xd;
    y = 1;&#xd;&#xd;&#xd;&#xd;
} else {&#xd;&#xd;&#xd;&#xd;
    y = 0;&#xd;&#xd;&#xd;&#xd;
}</relation>
</relations>
</model>
