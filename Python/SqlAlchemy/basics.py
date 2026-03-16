from sqlalchemy import create_engine, MetaData, Table, Column, Integer, String

engine = create_engine('postgresql://postgres:Ouma%40218@localhost:5432/postgres', echo = True)

meta = MetaData()

people = Table(
    "people",
    meta,
    Column('id', Integer, primary_key = True),
    Column('name', String, nullable = False),
    Column('age', Integer)
)

meta.create_all(engine)

conn = engine.connect()

