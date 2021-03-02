import React from "react";
import Highcharts from 'highcharts';
import ReactHighcharts from 'react-highcharts';

const date1 = new Date(2021, 0, 1)
const date2 = new Date(2022, 0, 1)
const date3 = new Date(2023, 0, 1)

const data = [
  [
    date1.valueOf(),
    100000
  ],
  [
    date2.valueOf(),
    140000
  ],
  [
    date3.valueOf(),
    210000
  ],
];

const options = {
  title: {
    text: null,
  },
  xAxis: {
    type: 'datetime',
    title: {
      text: 'Year',
    },
    crosshair: true,
  },
  yAxis: {
    title: {
      text: 'Value ($)',
    },
  },
  legend: {
    enabled: false,
  },
  series: [{
    type: 'line',
    data: data,
  }],
  tooltip: {
    formatter: function() {
        return  '<b>' + Highcharts.dateFormat('%b %e, %Y', new Date(this.x)) +'</b><br/>$' + this.y;
    }
  },
  credits: {
    enabled: false,
  },
};

const gain = 1000;
const years = 10;

const TimeSeries = () => <div>
  <p> This page allows you to customize your investments and view the potential growth of ${gain} over a period of {years} years.</p>
  <ReactHighcharts config = {options} />
</div>

export default TimeSeries
