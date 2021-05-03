<model id="{9eb223c3-1acd-425e-882a-842dc8ecbd6c}" shortName="Model 1" formatXmlVersion="2.0" description="Model 1">
<class id="{6b5cbcf3-61cf-46fa-9070-5b3d40e331aa}" shortName="Model 1">
<parameters/>
<rules>
<rule id="81d3a66c-afbc-4a24-aa4b-373661b3227f" shortName="Rule36" relation="3a8003d1-72cf-441e-90af-f2f28a2e4cd0" resultId="h:8ef7a231-1e71-472d-98ce-c435a6fae4b6" initId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903;g:73f94d1b-6753-4299-a2af-db27963b0ab3;Ep:55490198-7bd5-4324-9d41-eb5aa7c96c26"/>
<rule id="9a37e7ef-7886-4833-b112-f560580c7b6a" shortName="Rule34" relation="e7a677e5-9fd7-4cf7-a5fd-f8408357e6ce" resultId="Ep:55490198-7bd5-4324-9d41-eb5aa7c96c26" initId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903;h:8ef7a231-1e71-472d-98ce-c435a6fae4b6;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="9ae2791a-ef2a-460c-b1d7-c24106df6017" shortName="Rule35" relation="80383f7f-255d-46cf-adb6-57ff6ed7cae2" resultId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903" initId="h:8ef7a231-1e71-472d-98ce-c435a6fae4b6;g:73f94d1b-6753-4299-a2af-db27963b0ab3;Ep:55490198-7bd5-4324-9d41-eb5aa7c96c26"/>
<rule id="d5710bf7-881e-4799-a63b-c521d50447cc" shortName="Rule43" relation="544eea05-eef0-4d91-9fe7-c6c993061bf4" resultId="F:6c9c465e-8d00-4b09-bf54-f7d36bfd7c64" initId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="eb1d339f-f516-49ed-b826-cece50aa80d1" shortName="Rule45" relation="3dbb57c2-d97a-4555-b1fe-e36f5fd77d69" resultId="F2:72a78546-866e-41ca-91e4-0d0e9c3bf0c4" initId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
</rules>
<constraints/>
<classes>
<class id="43e875ed-6c7a-4d85-bb80-e3be9493bb9c" shortName="Давление твердых тел, жидкостей и газов">
<parameters>
<parameter id="10fa3ffd-c23b-4592-8037-a1f71f09f3b4" shortName="p" description="Давление [Па]" type="double"/>
<parameter id="39c81109-8205-417f-b784-7760b653a1e5" shortName="FArh" description="Сила Архимеда [Н]" type="double"/>
<parameter id="89d7e650-4c32-4d86-93d8-8d0711186d1a" shortName="g" defaultValue="10.00" description="10 м/с2 — ускорение свободного падения" type="double"/>
<parameter id="8a4f46be-dce1-4b76-8543-d571c3acb684" shortName="m" description="Масса [кг]" type="double"/>
<parameter id="9eff2384-a07e-488d-8f23-bf378f3242e5" shortName="h" description="Высота жидкости [м]" type="double"/>
<parameter id="bb85731f-2ee1-430d-bda2-e9b65246fad7" shortName="F" description="Сила при давлении [Н]" type="double"/>
<parameter id="bfbb5155-004a-407c-98f4-3b36654ac7e4" shortName="S" description="Площадь [м2]" type="double"/>
<parameter id="e7d6c84a-bb6d-401b-b166-7adfe62a1242" shortName="V" description="Объем [м3]" type="double"/>
<parameter id="e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12" shortName="ro" description="Плотность [кг/м3]" type="double"/>
</parameters>
<rules>
<rule id="05bb4f9c-9aef-43b3-935c-a7178ee81aea" shortName="Rule17" relation="3c6cf32b-817a-4131-81c9-22314dca420d" resultId="S:bfbb5155-004a-407c-98f4-3b36654ac7e4" initId="F:bb85731f-2ee1-430d-bda2-e9b65246fad7;p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4"/>
<rule id="2488643f-757c-47ee-a3d9-496fe7272c2d" shortName="Rule21" relation="363745f9-4a45-42a6-bd2d-16fd70da85a8" resultId="FArh:39c81109-8205-417f-b784-7760b653a1e5" initId="V:e7d6c84a-bb6d-401b-b166-7adfe62a1242;ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12;g:89d7e650-4c32-4d86-93d8-8d0711186d1a"/>
<rule id="3b72185b-c43d-4e0a-ae4e-2673f2794c72" shortName="Rule22" relation="8deb43ac-0c82-47cf-bd68-dad723c3eed3" resultId="ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12" initId="FArh:39c81109-8205-417f-b784-7760b653a1e5;V:e7d6c84a-bb6d-401b-b166-7adfe62a1242;g:89d7e650-4c32-4d86-93d8-8d0711186d1a"/>
<rule id="3b737149-eb79-4fe1-91e1-c06151b75f27" shortName="Rule16" relation="4dbcd7a1-62a5-4e40-8c1e-90127ca45758" resultId="F:bb85731f-2ee1-430d-bda2-e9b65246fad7" initId="S:bfbb5155-004a-407c-98f4-3b36654ac7e4;p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4"/>
<rule id="4c0b6d5c-8846-460d-803d-a3244b4cb83f" shortName="Rule18" relation="1dc0fd0a-b82b-49fc-a99e-59bc977ac99f" resultId="p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4" initId="h:9eff2384-a07e-488d-8f23-bf378f3242e5;ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12;g:89d7e650-4c32-4d86-93d8-8d0711186d1a"/>
<rule id="6969bd77-5937-4860-b567-5d009e5972f7" shortName="Rule15" relation="4a4722d6-53e6-4f81-9a53-ffdb06563056" resultId="p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4" initId="S:bfbb5155-004a-407c-98f4-3b36654ac7e4;F:bb85731f-2ee1-430d-bda2-e9b65246fad7"/>
<rule id="711110d9-199d-4444-929d-2a961443c5ac" shortName="Rule19" relation="8921522f-bf25-48d9-80fa-89d2525c7f1a" resultId="ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12" initId="h:9eff2384-a07e-488d-8f23-bf378f3242e5;g:89d7e650-4c32-4d86-93d8-8d0711186d1a;p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4"/>
<rule id="b97c28a7-8cc8-478c-b91b-cbab436d3ba7" shortName="Rule20" relation="e7abce89-a4c5-43a9-a0d2-e40e6b5e803d" resultId="h:9eff2384-a07e-488d-8f23-bf378f3242e5" initId="ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12;g:89d7e650-4c32-4d86-93d8-8d0711186d1a;p:10fa3ffd-c23b-4592-8037-a1f71f09f3b4"/>
<rule id="bf0c9c45-1a33-4c64-8fdf-3b248c5ec070" shortName="Rule23" relation="a2852265-7aa2-4be4-96d6-455b1a842cf0" resultId="V:e7d6c84a-bb6d-401b-b166-7adfe62a1242" initId="FArh:39c81109-8205-417f-b784-7760b653a1e5;ro:e9ac0e6f-8d9b-4247-ba9a-9a67f11fbe12;g:89d7e650-4c32-4d86-93d8-8d0711186d1a"/>
</rules>
<constraints/>
<classes/>
</class>
<class id="762cf678-f3f5-41d1-b1e8-27ef6eec115b" shortName="Взаимодействие тел">
<parameters>
<parameter id="1d0b5eae-1aec-499e-9168-99ce1e0ded2a" shortName="P" description="Вес тела [Н]" type="double"/>
<parameter id="3940fbbb-ca28-4657-852d-58361e2425a8" shortName="s" description="Путь [м]" type="double"/>
<parameter id="54a4d69f-c306-4296-a10a-ed9cfe591371" shortName="F1" description="1-я сила [H]" type="double"/>
<parameter id="5c598238-4745-4c82-98b8-1f24174d3c00" shortName="ro" description="Плотность [кг/м3]" type="double"/>
<parameter id="662af710-e75e-49e3-8eb5-f15879634503" shortName="F3" description="3-я сила [H]" type="double"/>
<parameter id="6e43ce7a-2a9d-4f1c-82de-6c11e5af9e00" shortName="k" description="Жесткость [Н/м]" type="double"/>
<parameter id="73f94d1b-6753-4299-a2af-db27963b0ab3" shortName="g" defaultValue="10.00" description="10 м/с2 — ускорение свободного падения" type="double"/>
<parameter id="80264806-8ecd-4dc3-9814-529fd70845bb" shortName="FUpr" description="Сила упругости [H]" type="double"/>
<parameter id="9831a31b-0dcd-44e2-84dd-a2475ce728d1" shortName="F2" description="2-я сила [H]" type="double"/>
<parameter id="99e6fbce-a5a3-447d-84e3-7df2dec11ac2" shortName="t" description="Время [с]" type="double"/>
<parameter id="9fb7b42b-32f5-4e39-8525-2d1b32e2b45b" shortName="v" description="Скорость [м/с]" type="double"/>
<parameter id="b659d0a1-965b-4001-8b62-5e522a967b2e" shortName="F4" description="4-я сила [H]" type="double"/>
<parameter id="c61a3e60-addc-4a11-a095-4c2d50f77a42" shortName="FTaj" description="Сила тяжести [Н]" type="double"/>
<parameter id="cee7d9bc-bd66-4298-b93a-1f53de4f6a77" shortName="V" description="Объем [м3]" type="double"/>
<parameter id="db24c584-fcc0-4036-ad87-f8fb25e4d62b" shortName="dl" description="Удлинение [м]" type="double"/>
<parameter id="e2bfab6f-493a-4fb7-ba4f-0d19ec351743" shortName="R" description="Равнодействующая [Н]" type="double"/>
<parameter id="e598506f-e20e-4241-a2dd-cc1ef1fcea55" shortName="m" description="Масса [кг]" type="double"/>
</parameters>
<rules>
<rule id="0c57d9d4-6a41-42d4-9751-871267ac52a5" shortName="Rule3" relation="233fad65-b17d-421d-a816-74773c6ef488" resultId="s:3940fbbb-ca28-4657-852d-58361e2425a8" initId="t:99e6fbce-a5a3-447d-84e3-7df2dec11ac2;v:9fb7b42b-32f5-4e39-8525-2d1b32e2b45b"/>
<rule id="188c41bd-d4b8-49b4-baa0-7d0873742061" shortName="Rule9" relation="6169fa35-9237-4548-aa72-576883be80c5" resultId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55" initId="V:cee7d9bc-bd66-4298-b93a-1f53de4f6a77;ro:5c598238-4745-4c82-98b8-1f24174d3c00"/>
<rule id="46f3d85c-1912-4f98-8676-1f3fe4b8e2c0" shortName="Rule2" relation="f9cd0e97-6683-471f-bde4-3ce751fbd8c1" resultId="t:99e6fbce-a5a3-447d-84e3-7df2dec11ac2" initId="s:3940fbbb-ca28-4657-852d-58361e2425a8;v:9fb7b42b-32f5-4e39-8525-2d1b32e2b45b"/>
<rule id="4c5c6049-eaaa-4626-8cff-dcd4ed6e7a03" shortName="Rule1" relation="7996c8c9-9185-4b1c-b5f8-743431b37fcd" resultId="v:9fb7b42b-32f5-4e39-8525-2d1b32e2b45b" initId="s:3940fbbb-ca28-4657-852d-58361e2425a8;t:99e6fbce-a5a3-447d-84e3-7df2dec11ac2"/>
<rule id="5164de93-c077-4041-bf8e-e332a858c580" shortName="Rule4" relation="aab18c47-0ae3-44e9-82e8-c454fdcf08f8" resultId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55" initId="FTaj:c61a3e60-addc-4a11-a095-4c2d50f77a42;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="66b4dbd2-7705-42d2-8ae7-0f5f046ee349" shortName="Rule10" relation="24ca2b8c-6609-4c57-8ba0-fe4ea47189d5" resultId="FTaj:c61a3e60-addc-4a11-a095-4c2d50f77a42" initId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="8337c26f-a75a-4d02-99a4-978a40444577" shortName="Rule5" relation="15c571a0-6f6c-4991-a9cc-cfe5f25d8d71" resultId="R:e2bfab6f-493a-4fb7-ba4f-0d19ec351743" initId="F2:9831a31b-0dcd-44e2-84dd-a2475ce728d1;F4:b659d0a1-965b-4001-8b62-5e522a967b2e;F1:54a4d69f-c306-4296-a10a-ed9cfe591371;F3:662af710-e75e-49e3-8eb5-f15879634503"/>
<rule id="a229e9e6-4464-4be5-b0f9-aab1c5c241f5" shortName="Rule11" relation="f3cc9947-f286-417d-a243-c101ed724c9e" resultId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55" initId="P:1d0b5eae-1aec-499e-9168-99ce1e0ded2a;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="b074adce-b340-4034-a343-046471dc0eb3" shortName="Rule13" relation="6cd35890-82c2-409a-901b-ab79a3c4527c" resultId="k:6e43ce7a-2a9d-4f1c-82de-6c11e5af9e00" initId="dl:db24c584-fcc0-4036-ad87-f8fb25e4d62b;FUpr:80264806-8ecd-4dc3-9814-529fd70845bb"/>
<rule id="b37d8d4a-b8bf-445c-b0dd-7f471c6a74a2" shortName="Rule6" relation="aca54aea-89da-4862-bf49-b1447350386b" resultId="P:1d0b5eae-1aec-499e-9168-99ce1e0ded2a" initId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55;g:73f94d1b-6753-4299-a2af-db27963b0ab3"/>
<rule id="e1e41c0f-8c4d-4bc0-b2f1-fe8ba479aee5" shortName="Rule8" relation="80d5a8ce-8a33-41d8-b93d-91548cc1e0ac" resultId="V:cee7d9bc-bd66-4298-b93a-1f53de4f6a77" initId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55;ro:5c598238-4745-4c82-98b8-1f24174d3c00"/>
<rule id="ec4df630-4bff-4e12-a64a-847c7d1dd0b6" shortName="Rule12" relation="79a3f77e-2e39-4d57-938b-ba5a1eec4ea5" resultId="FUpr:80264806-8ecd-4dc3-9814-529fd70845bb" initId="dl:db24c584-fcc0-4036-ad87-f8fb25e4d62b;k:6e43ce7a-2a9d-4f1c-82de-6c11e5af9e00"/>
<rule id="efaf6ad8-9884-44b4-9e37-bdad9977c86e" shortName="Rule7" relation="02ed1b8f-4fa0-474e-8e59-4b4567e28f99" resultId="ro:5c598238-4745-4c82-98b8-1f24174d3c00" initId="m:e598506f-e20e-4241-a2dd-cc1ef1fcea55;V:cee7d9bc-bd66-4298-b93a-1f53de4f6a77"/>
<rule id="f8aecf32-aa7b-4fee-af16-224533feca7b" shortName="Rule14" relation="eada54e4-092d-4976-aeb4-22c38232161e" resultId="dl:db24c584-fcc0-4036-ad87-f8fb25e4d62b" initId="FUpr:80264806-8ecd-4dc3-9814-529fd70845bb;k:6e43ce7a-2a9d-4f1c-82de-6c11e5af9e00"/>
</rules>
<constraints/>
<classes/>
</class>
<class id="c4a7a00f-6060-4409-974f-b5eea680d2e3" shortName="Работа, мощность, энергия">
<parameters>
<parameter id="021ff70b-78be-403e-ae49-db1aac9e0d7e" shortName="l1" description="1-е плечо силы [м]" type="double"/>
<parameter id="09db767e-45c8-42a2-9db6-4ad1fe1ddf5b" shortName="N" description="Мощность [Вт]" type="double"/>
<parameter id="0cec056f-4fa0-482c-880e-160f8bae6f80" shortName="l2" description="2-е плечо силы [м]" type="double"/>
<parameter id="1bf2d3d2-a3ec-4e3a-b86e-6ed910bc7d0c" shortName="M" description="Момент силы [Н·м]" type="double"/>
<parameter id="36328348-b3b3-4d25-84a9-a6e272bc9be4" shortName="A" description="Работа [Дж]" type="double"/>
<parameter id="399537f0-e5f8-4a7f-9b7c-8edd4b2d2a73" shortName="T" description="Время выполнения работы [с]" type="double"/>
<parameter id="3c508bbd-bb61-4ff5-a272-cebd713d7e14" shortName="F1" description="Сила, действующая на 1-е плечо" type="double"/>
<parameter id="42abdeef-5939-45bc-9be2-6b5cdd515c3f" shortName="V" description="Объем [м3]" type="double"/>
<parameter id="4b5c591c-98ac-474e-ae0f-b252b8cdbc1f" shortName="nu" description="Коэффициент полезного действия [%]" type="double"/>
<parameter id="55490198-7bd5-4324-9d41-eb5aa7c96c26" shortName="Ep" description="Потенциальная энергия [Дж]" type="double"/>
<parameter id="6c55eb56-4670-4299-9df1-504431bac2b1" shortName="Az" description="Затраченная работа [Дж]" type="double"/>
<parameter id="6c9c465e-8d00-4b09-bf54-f7d36bfd7c64" shortName="F" description="Сила [Н]" type="double"/>
<parameter id="72a78546-866e-41ca-91e4-0d0e9c3bf0c4" shortName="F2" description="Сила, действующая на 2-е плечо" type="double"/>
<parameter id="7777b11c-ccf6-40b4-a89f-dfa507aac139" shortName="ro" description="Плотность [кг/м3]" type="double"/>
<parameter id="7f4833de-4482-428d-8190-26c089ab38fc" shortName="l" description="Плечо силы [м]" type="double"/>
<parameter id="8871c637-4c99-4e8f-9985-b0ae7ceff94a" shortName="Ap" description="Полезная работа [Дж]" type="double"/>
<parameter id="8ef7a231-1e71-472d-98ce-c435a6fae4b6" shortName="h" description="Высота [м]" type="double"/>
<parameter id="b21c8c1b-a87f-4131-b823-e4f5b1f855d1" shortName="v" description="Скорость [м/с]" type="double"/>
<parameter id="b9f13474-8988-4fce-a891-cc00bb65b4d7" shortName="Ek" description="Кинетическая энергия [Дж]" type="double"/>
<parameter id="cee8f8cc-cb8e-4fce-9425-26fe897ef903" shortName="m" description="Масса тела [кг]" type="double"/>
<parameter id="d840a504-79fe-4e69-9777-9acfb984ef13" shortName="S" description="Перемещение тела [м]" type="double"/>
<parameter id="ff0c60f4-6b9e-4925-97ab-26df316216c4" shortName="FTaj" description="Сила тяжести [Н]" type="double"/>
</parameters>
<rules>
<rule id="0a3ebec3-4de9-49bf-819b-dd9cb8f663f5" shortName="Rule37" relation="37de8976-50f3-448d-8060-df255cbf1885" resultId="Ek:b9f13474-8988-4fce-a891-cc00bb65b4d7" initId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903;v:b21c8c1b-a87f-4131-b823-e4f5b1f855d1"/>
<rule id="1cd988e8-a891-4277-a166-fc3482480d50" shortName="Rule24" relation="b7b30bb3-e2ca-45ad-9309-b9096ac10536" resultId="A:36328348-b3b3-4d25-84a9-a6e272bc9be4" initId="S:d840a504-79fe-4e69-9777-9acfb984ef13;F:6c9c465e-8d00-4b09-bf54-f7d36bfd7c64"/>
<rule id="372d0b12-fc89-484d-89fa-f3331f398432" shortName="Rule38" relation="4e2943cd-4451-4178-b8b1-8374bff4b10d" resultId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903" initId="Ek:b9f13474-8988-4fce-a891-cc00bb65b4d7;v:b21c8c1b-a87f-4131-b823-e4f5b1f855d1"/>
<rule id="4c694542-a1af-4e5b-8695-1d625f3e4df4" shortName="Rule31" relation="5394981a-dc8c-4f1b-b0dd-b887c89c172a" resultId="l2:0cec056f-4fa0-482c-880e-160f8bae6f80" initId="l1:021ff70b-78be-403e-ae49-db1aac9e0d7e;F2:72a78546-866e-41ca-91e4-0d0e9c3bf0c4;F1:3c508bbd-bb61-4ff5-a272-cebd713d7e14"/>
<rule id="671655e2-f010-4ad5-b62c-7c14beac33e4" shortName="Rule33" relation="3b062aae-2b58-4ca5-8219-e4758ffb9e41" resultId="Az:6c55eb56-4670-4299-9df1-504431bac2b1" initId="nu:4b5c591c-98ac-474e-ae0f-b252b8cdbc1f;Ap:8871c637-4c99-4e8f-9985-b0ae7ceff94a"/>
<rule id="6d71bc1f-e144-4a75-8dec-7a57aec5d07a" shortName="Rule39" relation="ae90f00b-e713-435b-bef8-233ae9e132a3" resultId="F1:3c508bbd-bb61-4ff5-a272-cebd713d7e14" initId="l1:021ff70b-78be-403e-ae49-db1aac9e0d7e;F2:72a78546-866e-41ca-91e4-0d0e9c3bf0c4;l2:0cec056f-4fa0-482c-880e-160f8bae6f80"/>
<rule id="75c3fe82-f19f-4ea2-97e2-708a77d964c7" shortName="Rule41" relation="f443effd-3518-4139-b809-83521b10b6b3" resultId="M:1bf2d3d2-a3ec-4e3a-b86e-6ed910bc7d0c" initId="F:6c9c465e-8d00-4b09-bf54-f7d36bfd7c64;l:7f4833de-4482-428d-8190-26c089ab38fc"/>
<rule id="8d90cec0-4d2f-4719-96fd-05a72edd0d4a" shortName="Rule29" relation="85f594dc-0dcb-4dde-924e-a3e326206021" resultId="T:399537f0-e5f8-4a7f-9b7c-8edd4b2d2a73" initId="A:36328348-b3b3-4d25-84a9-a6e272bc9be4;N:09db767e-45c8-42a2-9db6-4ad1fe1ddf5b"/>
<rule id="97631a59-eb78-404f-8120-0e3b31b89e6a" shortName="Rule40" relation="648d7093-7754-4ee2-8ec3-8f72c8917f97" resultId="F2:72a78546-866e-41ca-91e4-0d0e9c3bf0c4" initId="l1:021ff70b-78be-403e-ae49-db1aac9e0d7e;l2:0cec056f-4fa0-482c-880e-160f8bae6f80;F1:3c508bbd-bb61-4ff5-a272-cebd713d7e14"/>
<rule id="9b3466da-a5d1-418c-bb37-57511b0a7dec" shortName="Rule28" relation="a34ccf72-4df2-4deb-9d55-f4836ca5360a" resultId="A:36328348-b3b3-4d25-84a9-a6e272bc9be4" initId="T:399537f0-e5f8-4a7f-9b7c-8edd4b2d2a73;N:09db767e-45c8-42a2-9db6-4ad1fe1ddf5b"/>
<rule id="b3cd9ef1-5394-4064-af29-466488f44b0a" shortName="Rule25" relation="86aa04f9-b203-4638-ac3b-9f17a6700463" resultId="F:6c9c465e-8d00-4b09-bf54-f7d36bfd7c64" initId="S:d840a504-79fe-4e69-9777-9acfb984ef13;A:36328348-b3b3-4d25-84a9-a6e272bc9be4"/>
<rule id="d149296c-000c-47d9-8cd7-05281baced36" shortName="Rule44" relation="7b63a284-e29e-4b8d-acb9-f30df678e323" resultId="m:cee8f8cc-cb8e-4fce-9425-26fe897ef903" initId="ro:7777b11c-ccf6-40b4-a89f-dfa507aac139;v:b21c8c1b-a87f-4131-b823-e4f5b1f855d1"/>
<rule id="e0c079bd-2b18-4e44-8d2f-25adad4b2a1a" shortName="Rule32" relation="07470b42-9539-4672-945b-3318148e6c35" resultId="Ap:8871c637-4c99-4e8f-9985-b0ae7ceff94a" initId="nu:4b5c591c-98ac-474e-ae0f-b252b8cdbc1f;Az:6c55eb56-4670-4299-9df1-504431bac2b1"/>
<rule id="ebe53429-4d71-4d9b-9ab4-cf621b2d87fb" shortName="Rule26" relation="3480cfbf-2ad0-4c90-8f79-d15ff34132eb" resultId="S:d840a504-79fe-4e69-9777-9acfb984ef13" initId="F:6c9c465e-8d00-4b09-bf54-f7d36bfd7c64;A:36328348-b3b3-4d25-84a9-a6e272bc9be4"/>
<rule id="ed343676-1f27-48bd-b1df-c1b0c3dd23e8" shortName="Rule42" relation="83d6ffea-ee05-4c7f-b21f-c33009b257ac" resultId="nu:4b5c591c-98ac-474e-ae0f-b252b8cdbc1f" initId="Az:6c55eb56-4670-4299-9df1-504431bac2b1;Ap:8871c637-4c99-4e8f-9985-b0ae7ceff94a"/>
<rule id="ee2fbb02-8092-4c08-ba43-853a5d4d986d" shortName="Rule30" relation="be48ea47-da83-41c1-b3ab-d77433f338ec" resultId="l1:021ff70b-78be-403e-ae49-db1aac9e0d7e" initId="F2:72a78546-866e-41ca-91e4-0d0e9c3bf0c4;l2:0cec056f-4fa0-482c-880e-160f8bae6f80;F1:3c508bbd-bb61-4ff5-a272-cebd713d7e14"/>
<rule id="f4a7c34e-fe4c-4aef-b4b1-d4da2b0390d0" shortName="Rule27" relation="2976d5e2-c432-4a14-927d-ee70f4f70f9c" resultId="N:09db767e-45c8-42a2-9db6-4ad1fe1ddf5b" initId="A:36328348-b3b3-4d25-84a9-a6e272bc9be4;T:399537f0-e5f8-4a7f-9b7c-8edd4b2d2a73"/>
</rules>
<constraints/>
<classes/>
</class>
</classes>
</class>
<relations>
<relation id="02ed1b8f-4fa0-474e-8e59-4b4567e28f99" shortName="Формула 7" inObj="m:double;V:double" relationType="simple" outObj="ro:double">ro=&#xd;&#xd;&#xd;
m/&#xd;&#xd;&#xd;
V</relation>
<relation id="07470b42-9539-4672-945b-3318148e6c35" shortName="Формула 32" inObj="nu:double;Az:double" relationType="simple" outObj="Ap:double">Ap = nu*Az/100</relation>
<relation id="15c571a0-6f6c-4991-a9cc-cfe5f25d8d71" shortName="Формула 5" inObj="F2:double;F4:double;F1:double;F3:double" relationType="simple" description="Равнодействующая сила" outObj="R:double">R=Math.abs((F1+F2) - (F3+F4))</relation>
<relation id="1dc0fd0a-b82b-49fc-a99e-59bc977ac99f" shortName="Формула 18 " inObj="h:double;ro:double;g:double" relationType="simple" outObj="p:double">p = ro*g*h</relation>
<relation id="233fad65-b17d-421d-a816-74773c6ef488" shortName="Формула 3" inObj="t:double;v:double" relationType="simple" description="Путь" outObj="s:double">s=v*t</relation>
<relation id="24ca2b8c-6609-4c57-8ba0-fe4ea47189d5" shortName="Формула 10" inObj="m:double;g:double" relationType="simple" outObj="FTaj:double">FTaj = g*m</relation>
<relation id="2976d5e2-c432-4a14-927d-ee70f4f70f9c" shortName="Формула 27" inObj="A:double;T:double" relationType="simple" outObj="N:double">N = A/T</relation>
<relation id="3480cfbf-2ad0-4c90-8f79-d15ff34132eb" shortName="Формула 26" inObj="F:double;A:double" relationType="simple" outObj="S:double">S = A/F</relation>
<relation id="363745f9-4a45-42a6-bd2d-16fd70da85a8" shortName="Формула 21" inObj="V:double;ro:double;g:double" relationType="simple" outObj="FArh:double">FArh = g*ro*V</relation>
<relation id="37de8976-50f3-448d-8060-df255cbf1885" shortName="Формула 37" inObj="m:double;v:double" relationType="simple" outObj="Ek:double">Ek = m *Math.pow(v,2)/2</relation>
<relation id="3a8003d1-72cf-441e-90af-f2f28a2e4cd0" shortName="Формула 36" inObj="m:double;g:double;Ep:double" relationType="simple" outObj="h:double">h = Ep/(m*g)</relation>
<relation id="3b062aae-2b58-4ca5-8219-e4758ffb9e41" shortName="Формула 33" inObj="nu:double;Ap:double" relationType="simple" outObj="Az:double">Az = Ap*100 / nu</relation>
<relation id="3c6cf32b-817a-4131-81c9-22314dca420d" shortName="Формула 17" inObj="F:double;p:double" relationType="simple" outObj="S:double">S = F / p</relation>
<relation id="3dbb57c2-d97a-4555-b1fe-e36f5fd77d69" shortName="Формула 45" inObj="m:double;g:double" relationType="simple" outObj="F2:double">F2 = m*g</relation>
<relation id="4a4722d6-53e6-4f81-9a53-ffdb06563056" shortName="Формула 15" inObj="S:double;F:double" relationType="simple" outObj="p:double">p = F/S</relation>
<relation id="4dbcd7a1-62a5-4e40-8c1e-90127ca45758" shortName="Формула 16" inObj="S:double;p:double" relationType="simple" outObj="F:double">F = p * S</relation>
<relation id="4e2943cd-4451-4178-b8b1-8374bff4b10d" shortName="Формула 38" inObj="Ek:double;v:double" relationType="simple" outObj="m:double">m = 2*Ek/Math.pow(v,2)</relation>
<relation id="5394981a-dc8c-4f1b-b0dd-b887c89c172a" shortName="Формула 31" inObj="l1:double;F2:double;F1:double" relationType="simple" outObj="l2:double">l2 = F1*l1 / F2</relation>
<relation id="544eea05-eef0-4d91-9fe7-c6c993061bf4" shortName="Формула 43" inObj="m:double;g:double" relationType="simple" outObj="F:double">F = m*g</relation>
<relation id="6169fa35-9237-4548-aa72-576883be80c5" shortName="Формула 9" inObj="V:double;ro:double" relationType="simple" outObj="m:double">m = ro * V</relation>
<relation id="648d7093-7754-4ee2-8ec3-8f72c8917f97" shortName="Формула 40" inObj="l1:double;l2:double;F1:double" relationType="simple" outObj="F2:double">F2 = F1*l1 / l2</relation>
<relation id="6cd35890-82c2-409a-901b-ab79a3c4527c" shortName="Формула 13" inObj="dl:double;FUpr:double" relationType="simple" outObj="k:double">k = FUpr/dl</relation>
<relation id="7996c8c9-9185-4b1c-b5f8-743431b37fcd" shortName="Формула 1" inObj="s:double;t:double" relationType="simple" description="Средняя скорость пути" outObj="v:double">v=&#xd;&#xd;&#xd;
s/t</relation>
<relation id="79a3f77e-2e39-4d57-938b-ba5a1eec4ea5" shortName="Формула 12" inObj="dl:double;k:double" relationType="simple" outObj="FUpr:double">FUpr = k*dl</relation>
<relation id="7b63a284-e29e-4b8d-acb9-f30df678e323" shortName="Формула 44" inObj="ro:double;v:double" relationType="simple" outObj="m:double">m = ro*v</relation>
<relation id="80383f7f-255d-46cf-adb6-57ff6ed7cae2" shortName="Формула 35" inObj="h:double;g:double;Ep:double" relationType="simple" outObj="m:double">m = Ep/(g*h)</relation>
<relation id="80d5a8ce-8a33-41d8-b93d-91548cc1e0ac" shortName="Формула 8" inObj="m:double;ro:double" relationType="simple" outObj="V:double">V = m/ro</relation>
<relation id="83d6ffea-ee05-4c7f-b21f-c33009b257ac" shortName="Формула 42" inObj="Az:double;Ap:double" relationType="simple" outObj="nu:double">nu = Ap/Az * 100</relation>
<relation id="85f594dc-0dcb-4dde-924e-a3e326206021" shortName="Формула 29" inObj="A:double;N:double" relationType="simple" outObj="T:double">T = A/N</relation>
<relation id="86aa04f9-b203-4638-ac3b-9f17a6700463" shortName="Формула 25" inObj="S:double;A:double" relationType="simple" outObj="F:double">F = A/S</relation>
<relation id="8921522f-bf25-48d9-80fa-89d2525c7f1a" shortName="Формула 19" inObj="h:double;g:double;p:double" relationType="simple" outObj="ro:double">ro = p/(g*h)</relation>
<relation id="8deb43ac-0c82-47cf-bd68-dad723c3eed3" shortName="Формула 22" inObj="FArh:double;V:double;g:double" relationType="simple" outObj="ro:double">ro = FArh / (g*V)</relation>
<relation id="a2852265-7aa2-4be4-96d6-455b1a842cf0" shortName="Формула 23" inObj="FArh:double;ro:double;g:double" relationType="simple" outObj="V:double">V = FArh / (g*ro)</relation>
<relation id="a34ccf72-4df2-4deb-9d55-f4836ca5360a" shortName="Формула 28" inObj="T:double;N:double" relationType="simple" outObj="A:double">A = N*T</relation>
<relation id="aab18c47-0ae3-44e9-82e8-c454fdcf08f8" shortName="Формула 4" inObj="FTaj:double;g:double" relationType="simple" description="Поиск массы" outObj="m:double">m=&#xd;&#xd;&#xd;
FTaj/&#xd;&#xd;&#xd;
g</relation>
<relation id="aca54aea-89da-4862-bf49-b1447350386b" shortName="Формула 6" inObj="m:double;g:double" relationType="simple" outObj="P:double">P=g*m</relation>
<relation id="ae90f00b-e713-435b-bef8-233ae9e132a3" shortName="Формула 39" inObj="l1:double;F2:double;l2:double" relationType="simple" outObj="F1:double">F1 = F2*l2/l1</relation>
<relation id="b7b30bb3-e2ca-45ad-9309-b9096ac10536" shortName="Формула 24" inObj="S:double;F:double" relationType="simple" outObj="A:double">A = F*S</relation>
<relation id="be48ea47-da83-41c1-b3ab-d77433f338ec" shortName="Формула 30" inObj="F2:double;l2:double;F1:double" relationType="simple" outObj="l1:double">l1 = F2*l2/F1</relation>
<relation id="e7a677e5-9fd7-4cf7-a5fd-f8408357e6ce" shortName="Формула 34" inObj="m:double;h:double;g:double" relationType="simple" outObj="Ep:double">Ep = m*g*h</relation>
<relation id="e7abce89-a4c5-43a9-a0d2-e40e6b5e803d" shortName="Формула 20" inObj="ro:double;g:double;p:double" relationType="simple" outObj="h:double">h = p/(ro*g)</relation>
<relation id="eada54e4-092d-4976-aeb4-22c38232161e" shortName="Формула 14" inObj="FUpr:double;k:double" relationType="simple" outObj="dl:double">dl = FUpr/k</relation>
<relation id="f3cc9947-f286-417d-a243-c101ed724c9e" shortName="Формула 11" inObj="P:double;g:double" relationType="simple" outObj="m:double">m = P/g</relation>
<relation id="f443effd-3518-4139-b809-83521b10b6b3" shortName="Формула 41" inObj="F:double;l:double" relationType="simple" outObj="M:double">M = F*l</relation>
<relation id="f9cd0e97-6683-471f-bde4-3ce751fbd8c1" shortName="Формула 2" inObj="s:double;v:double" relationType="simple" description="Время пути" outObj="t:double">t=&#xd;&#xd;&#xd;
s/v</relation>
</relations>
</model>
