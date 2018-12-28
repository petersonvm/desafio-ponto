create index IX_C667B497 on ponto_dia (Competencia[$COLUMN_LENGTH:75$]);
create index IX_8DB5A4E7 on ponto_dia (Pis, Competencia[$COLUMN_LENGTH:75$]);

create index IX_C1A3BFF8 on ponto_marcacao (Pis, Data);
create index IX_907E8B0A on ponto_marcacao (Pis, DataReferencia);