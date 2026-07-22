import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {

  test("should return repository names for techiesyed", async () => {

    const mockData = {
      data: [
        { name: "ReactProject" },
        { name: "NodeProject" },
        { name: "JavaProject" }
      ]
    };

    axios.get.mockResolvedValue(mockData);

    const repos = await GitClient.getRepositories("techiesyed");

    expect(repos).toEqual([
      "ReactProject",
      "NodeProject",
      "JavaProject"
    ]);

    expect(axios.get).toHaveBeenCalledTimes(1);

    expect(axios.get).toHaveBeenCalledWith(
      "https://api.github.com/users/techiesyed/repos"
    );

  });

});