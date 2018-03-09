const year = new Date().getFullYear();
document.querySelector('.date').innerHTML = year;

const HOST = 'http://localhost:8888';

function initShopFilters(shops) {
    const shopsFilterSelect = document.querySelector('.shop-select');
    shops.forEach(shop => {
        const shopElement = document.createElement('option');
        shopElement.setAttribute('value', shop.id);
        shopElement.innerHTML = shop.name;
        shopsFilterSelect.appendChild(shopElement);
    });
}

function initShopTypesFilters(shopTypes) {
    const shopTypesFilterSelect = document.querySelector('.shop-types');
    shopTypes.forEach(shopType => {
        const shopTypeDiv = document.createElement('div');
        const shopTypeElement = document.createElement('input');
        shopTypeElement.setAttribute('type', 'checkbox');
        shopTypeElement.setAttribute('value', shopType);
        const shopTypeValue = document.createElement('label');
        shopTypeValue.appendChild(shopTypeElement);
        shopTypeValue.innerHTML += shopType;
        shopTypeDiv.appendChild(shopTypeValue);
        shopTypesFilterSelect.appendChild(shopTypeDiv);
    });
}

function initFilters(filters) {
    const { shops, shopTypes } = filters;
    initShopFilters(shops);
    initShopTypesFilters(shopTypes);
}

const filtersPromise = fetch(HOST + '/filters')
    .then(response => response.json())
    .then(filters => initFilters(filters))
    .catch(error => console.log(error));

function fetchProducts(shop) {
    return fetch(HOST + `/shops/${shop.id}/products`)
        .then(response => response.json())
        .catch(error => console.log(error));
}

function getFilteringParams() {
    const productNamePhrase = document.querySelector('.product-name').value;
    const shopIds = document.querySelector('.shop-select').value;
    const minProductPrice = document.querySelector('.min-price').value;
    const maxProductPrice = document.querySelector('.max-price').value;
    const shopTypesCheckboxes = document.querySelectorAll('.shop-types div label input');

    const shopTypes = Array.from(shopTypesCheckboxes)
        .filter(shopType => shopType.checked)
        .map(shopType => shopType.value);

    return {
        productNamePhrase,
        shopIds,
        shopTypes,
        minProductPrice,
        maxProductPrice
    }
}

function createShopElement(shop) {
    const shopElement = document.createElement('div');
    const shopNameElement = document.createElement('span');
    shopNameElement.innerHTML = shop.name;
    const shopFloorElement = document.createElement('span');
    shopFloorElement.innerHTML = shop.location.floor;
    const shopBoxElement = document.createElement('span');
    shopBoxElement.innerHTML = shop.location.box;
    shopElement.appendChild(shopNameElement);
    shopElement.appendChild(shopFloorElement);
    shopElement.appendChild(shopBoxElement);
    shopElement.addEventListener('click', () => showProducts(shop));
    
    return shopElement;
}

function showShops(shops) {
    const shopElementContainer = document.querySelector('.shop-elements');
    shops.forEach(shop => {
        const shopElement = createShopElement(shop);
        shopElementContainer.appendChild(shopElement);
    })
}

function showProducts(shop) {
    const productsContainer = document.querySelector('.shop-products');
    fetchProducts(shop).then(products =>
        products.forEach(product => {
            const productElement = document.createElement('div');
            const productName = document.createElement('span');
            productName.innerHTML = product.name;
            productElement.appendChild(productName);
            productsContainer.appendChild(productElement);
        }));
}

function getFilteredShops() {
    const filteringParams = getFilteringParams();
    console.log(filteringParams);
    fetchFilteredShops(filteringParams).then(showShops);
}

const button = document.querySelector('.button').addEventListener('click', getFilteredShops);

const createQueryParamsString = object => Object.keys(object)
    .filter(key => object[key] !== undefined)
    .filter(key => String(object[key]) !== '')
    .map(key => `${key}=${object[key]}`)
    .join('&');

function fetchFilteredShops(filteringParams) {
    const queryString = createQueryParamsString(filteringParams);
    return fetch(HOST + '/shops?' + queryString)
        .then(response => response.json())
        .catch(error => console.log(error));
}

