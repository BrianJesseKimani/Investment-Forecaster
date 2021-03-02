import React from "react";
import TimeSeries from "./TimeSeries";

const ForecasterHome = () => {
  return (
    <>
       <div>
            <h3>Investment Forecaster</h3>
            <TimeSeries />
            <h5 style={{marginTop: 10}}>Investment Allocations</h5>
        </div>
    </>
  );
};

export default ForecasterHome;
