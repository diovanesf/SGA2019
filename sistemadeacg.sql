
INSERT INTO `curriculo` (`id_curriculo`, `ano`, `status`) VALUES
(1, 2018, b'1');

INSERT INTO `grupo` (`id_grupo`, `nome`, `curriculo_id_curriculo`) VALUES
(1, 'Extensão', 1),
(2, 'Pesquisa', 1);

INSERT INTO `atividade` (`id_atividade`, `carga_horaria`, `descricao`, `detalhamento`, `grupo_id_grupo`) VALUES
(1, 2, 'asdwasdwasd', 'hawfsfasdadas', 1),
(2, 40, 'aaaaaaa', 'bbbbbbbbbb', 2);

INSERT INTO `docs_necessarios` (`id_doc_necessario`, `nome`) VALUES
(1, 'Doc 1'),
(2, 'Doc 2');

INSERT INTO `atividade_has_doc` (`id_atividade`, `id_doc_necessario`) VALUES
(1, 1),
(1, 2),
(2, 2);






