import pandas as pd
from sklearn.datasets import load_wine
from sklearn.linear_model import LogisticRegression

import flytekit.extras.sklearn
from flytekit import task, workflow


@task
def get_data() -> pd.DataFrame:
    return load_wine(as_frame=True).frame


@task
def process_data(data: pd.DataFrame) -> pd.DataFrame:
    return data.assign(target=lambda x: x["target"].where(x["target"] == 0, 1))


@task
def train_model(data: pd.DataFrame, hyperparameters: dict) -> LogisticRegression:
    features = data.drop("target", axis="columns")
    target = data["target"]
    return LogisticRegression(max_iter=3000, **hyperparameters).fit(features, target)


@workflow
def training_workflow(hyperparameters: dict) -> LogisticRegression:
    data = get_data()
    processed_data = process_data(data=data)
    return train_model(
        data=processed_data,
        hyperparameters=hyperparameters,
    )


if __name__ == "__main__":
    import json
    from argparse import ArgumentParser

    parser = ArgumentParser()
    parser.add_argument("--hyperparameters", type=json.loads)
    ...  # add the other options

    args = parser.parse_args()
    training_workflow(hyperparameters=args.hyperparameters)
