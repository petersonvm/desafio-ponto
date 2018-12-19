create table ponto_dia (
	Pis LONG not null,
	Data LONG not null,
	Competencia VARCHAR(75) null,
	Horas_Trabalhadas INTEGER,
	Horas_Extras INTEGER,
	Horas_Negativas INTEGER,
	primary key (Pis, Data)
);

create table ponto_marcacao (
	Pis LONG not null,
	DataHora LONG not null,
	Marcacao_valida BOOLEAN,
	primary key (Pis, DataHora)
);