insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Brasileira');
insert into cozinha (id, nome) values (4, 'Italiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('A La Carte', 10.00, 1);
insert into restaurante (nome, taxa_Frete, cozinha_id) values ('Larica', 8.00, 2);
insert into restaurante (nome, taxa_Frete, cozinha_id) values ('Bom Paladar', 12.00, 4);
insert into restaurante (nome, taxa_Frete, cozinha_id) values ('Receitas da Vovo', 18.00, 3);

insert into forma_pagamento (id, descricao) values (1, 'debito');
insert into forma_pagamento (id, descricao) values (2, 'credito');
insert into forma_pagamento (id, descricao) values (3, 'dinheiro');

insert into permissao (id, nome, descricao) values (1, 'consulta_cozinha', 'Permissao para consultar cozinhas');
insert into permissao (id, nome, descricao) values (2, 'editar_cozinha', 'Permissao para edicao de cozinhas');
insert into permissao (id, nome, descricao) values (3, 'excluir_cozinha', 'Permissao para exclusao de cozinhas');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'Goias');
insert into estado (id, nome) values (3, 'Sao Paulo');

insert into cidade (id, nome, estado_id) values (1, 'Uberlandia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Monte Verde', 1);
insert into cidade (id, nome, estado_id) values (3, 'Goiania', 2);
insert into cidade (id, nome, estado_id) values (4, 'Campinas', 3);