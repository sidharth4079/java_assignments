/*"id" : 101,
      "sku" : "Quaker",
      "name" : "Oats",
      "description" : "best Quality Oats",
      "unitprice" : 99.99,
      "imageurl" : "https://www.quakeroats.com/",
      "unitinstock" : 26,
      "datecreated" : "2020-03-23",
      "lastupdated" : "2022-06-22",
      "categoryid" : 1101,
*/

export class Product {
    constructor(public id : number,
                public sku : string,
                public name : string,
                public description : string,
                public unitprice : number,
                public imageurl : string,
                public unitinstock : number,
                public datecreated : string,
                public lastupdated : string,
                public categoryid : number){}
}
