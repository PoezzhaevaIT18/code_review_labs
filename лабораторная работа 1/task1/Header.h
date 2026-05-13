#ifndef HEADER_H_
#define HEADER_H_

#include <string>
#include <vector>

struct ArtifactResult {
	std::vector<int> indices;
	int total_weight;
	int total_volume;
};

ArtifactResult solve_artifacts(const std::string& filename);

#endif