import React from "react";
import ListofPlayers from "./ListofPlayers";
import IndianPlayers from "./IndianPlayers";

function App() {

  const flag = true;

  if (flag) {
    return <ListofPlayers />;
  } else {
    return <IndianPlayers />;
  }

}

export default App;