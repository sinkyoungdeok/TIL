from datetime import datetime
from airflow import DAG

default_arg = {
    'start_date': datetime(2021, 1, 1),
}

with DAG(dag_id='nft-pipeline', 
        schedule_interval='@daily',
        default_args=default_arg,
        tags = ['nft'],
        catchup=False) as dag:
    pass