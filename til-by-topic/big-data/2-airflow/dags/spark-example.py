from datetime import datetime
from airflow import DAG 
# from airflow.providers.apache.spark.operators.spark_sql import SparkSqlOperator
from airflow.providers.apache.spark.operators.spark_submit import SparkSubmitOperator

default_args = {
    'start_date': datetime(2021, 1, 1)
}

with DAG(dag_id="spark-example",
         schedule_interval="@daily",
         default_args=default_args,
         tags=['spark'],
         catchup=False) as dag:

    # sql_job = SparkSqlOperator(sql = "SELECT * FROM foobar", master='local', task_id="sql_job")

    submit_job = SparkSubmitOperator(
        application="/home/airflow/count_trips.py",
        task_id="submit_job",
        conn_id="spark_local"
    )