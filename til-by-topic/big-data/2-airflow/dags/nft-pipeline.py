from datetime import datetime
from airflow import DAG
from airflow.providers.sqlite.operators.sqlite import SqliteOperator

default_arg = {
    'start_date': datetime(2021, 1, 1),
}

with DAG(dag_id='nft-pipeline', 
        schedule_interval='@daily',
        default_args=default_arg,
        tags = ['nft'],
        catchup=False) as dag:
    
    createing_table = SqliteOperator(
        task_id = 'creating_table',
        sqlite_conn_id = 'db_sqlite',
        sql = '''
            CREATE TABLE IF NOT EXISTS nfts (
                token_id TEXT PRIMARY KEY,
                name TEXT NOT NULL,
                image_url TEXT NOT NULL
            )
        '''
    )