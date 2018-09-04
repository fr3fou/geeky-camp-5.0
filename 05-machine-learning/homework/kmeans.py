from sklearn import cluster
import numpy as np
import matplotlib.pyplot as plt

dots = np.array([[1, 2], [1, 4], [1, 0], [4, 3], [4, 4], [4, 0]])

kmeans = cluster.KMeans(n_clusters=2, random_state=0)
kmeans.fit(dots)

print('Clusters:')
print(kmeans.cluster_centers_)

centroids = kmeans.cluster_centers_

plt.plot(dots, 'bo', color='blue')
plt.scatter(centroids[:, 0], centroids[:, 1], color='red', marker='x', s=169)
plt.show()
