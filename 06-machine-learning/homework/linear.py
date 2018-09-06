from sklearn import linear_model, datasets
from sklearn.metrics import mean_squared_error, r2_score
import numpy as np
import matplotlib.pyplot as plt

boston_dataset = datasets.load_boston()

y_train = boston_dataset.target[:-100]
y_test = boston_dataset.target[-100:]

x = boston_dataset.data[:, np.newaxis, 5]

x_train = x[:-100]
x_test = x[-100:]

linear_regression = linear_model.LinearRegression()
linear_regression.fit(x_train, y_train)
y_pred = linear_regression.predict(x_test)

print("Coefficients: ", linear_regression.coef_)
print("Mean squared Error %f.02" % mean_squared_error(y_test, y_pred))
print("R2 score: %f " % r2_score(y_test, y_pred))

plt.scatter(x_test, y_test, color="blue")
plt.plot(x_test, y_pred, color="red")
plt.show();