from airflow import DAG
from airflow.providers.apache.spark.operators.spark_submit import SparkSubmitOperator

from datetime import datetime

default_args = {
  'start_date': datetime(2021, 1, 1),
}

with DAG(dag_id = "taxi_price-pipeline",
        schedule_interval="@daily",
        default_args=default_args,
        tags = ['spark'],
        catchup=False) as dag:
        
    # preprocess
    preprocess = SparkSubmitOperator(
        application="/home/airflow/preprocess.py",
        task_id="preprocess",
        conn_id="spark_local"
    )

    # tune hyperparameter 
    tune_hyperparameter = SparkSubmitOperator(
        application="/home/airflow/tune_hyperparameter.py", 
        task_id="tune_hyperparameter", 
        conn_id="spark_local"
    )

    train_model = SparkSubmitOperator(
        application="/home/airflow/train_model.py", 
        task_id="train_model",
        conn_id="spark_local"
    )

    preprocess >> tune_hyperparameter >> train_model